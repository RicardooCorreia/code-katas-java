package advent.of.code.y2025;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://adventofcode.com/2025/day/9
--- Day 9: Movie Theater ---
You slide down the firepole in the corner of the playground and land in the North Pole base movie theater!

The movie theater has a big tile floor with an interesting pattern. Elves here are redecorating the theater by switching out some of the square tiles in the big grid they form. Some of the tiles are red; the Elves would like to find the largest rectangle that uses red tiles for two of its opposite corners. They even have a list of where the red tiles are located in the grid (your puzzle input).

For example:

7,1
11,1
11,7
9,7
9,5
2,5
2,3
7,3
Showing red tiles as # and other tiles as ., the above arrangement of red tiles would look like this:

..............
.......#...#..
..............
..#....#......
..............
..#......#....
..............
.........#.#..
..............
You can choose any two red tiles as the opposite corners of your rectangle; your goal is to find the largest rectangle possible.

For example, you could make a rectangle (shown as O) with an area of 24 between 2,5 and 9,7:

..............
.......#...#..
..............
..#....#......
..............
..OOOOOOOO....
..OOOOOOOO....
..OOOOOOOO.#..
..............
Or, you could make a rectangle with area 35 between 7,1 and 11,7:

..............
.......OOOOO..
.......OOOOO..
..#....OOOOO..
.......OOOOO..
..#....OOOOO..
.......OOOOO..
.......OOOOO..
..............

--- Part Two ---
The Elves just remembered: they can only switch out tiles that are red or green. So, your rectangle can only include red or green tiles.

In your list, every red tile is connected to the red tile before and after it by a straight line of green tiles. The list wraps, so the first red tile is also connected to the last red tile. Tiles that are adjacent in your list will always be on either the same row or the same column.

Using the same example as before, the tiles marked X would be green:

..............
.......#XXX#..
.......X...X..
..#XXXX#...X..
..X........X..
..#XXXXXX#.X..
.........X.X..
.........#X#..
..............
In addition, all of the tiles inside this loop of red and green tiles are also green. So, in this example, these are the green tiles:

..............
.......#XXX#..
.......XXXXX..
..#XXXX#XXXX..
..XXXXXXXXXX..
..#XXXXXX#XX..
.........XXX..
.........#X#..
..............
The remaining tiles are never red nor green.

The rectangle you choose still must have red tiles in opposite corners, but any other tiles it includes must now be red or green. This significantly limits your options.

For example, you could make a rectangle out of red and green tiles with an area of 15 between 7,3 and 11,1:

..............
.......OOOOO..
.......OOOOO..
..#XXXXOOOOO..
..XXXXXXXXXX..
..#XXXXXX#XX..
.........XXX..
.........#X#..
..............
Or, you could make a thin rectangle with an area of 3 between 9,7 and 9,5:

..............
.......#XXX#..
.......XXXXX..
..#XXXX#XXXX..
..XXXXXXXXXX..
..#XXXXXXOXX..
.........OXX..
.........OX#..
..............
The largest rectangle you can make in this example using only red and green tiles has area 24. One way to do this is between 9,5 and 2,3:

..............
.......#XXX#..
.......XXXXX..
..OOOOOOOOXX..
..OOOOOOOOXX..
..OOOOOOOOXX..
.........XXX..
.........#X#..
..............
Using two red tiles as opposite corners, what is the largest area of any rectangle you can make using only red and green tiles?
 */
public class Day9MovieTheaterPart2 {

    public long largestRectangleArea(String input) {

        List<Point> redTiles = Arrays.stream(input.split("\\n"))
                .map(s -> s.split(","))
                .map(strings -> new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])))
                .toList();

        PolygonInfo polygonInfo = createPolygonInfo(redTiles);

        long maxArea = Long.MIN_VALUE;
        for (int i = 0; i < redTiles.size(); i++) {
            for (int j = i + 1; j < redTiles.size(); j++) {
                Point point1 = redTiles.get(i);
                Point point2 = redTiles.get(j);
                long area = area(point1, point2);

                if (area > maxArea && isValidRectangle(point1, point2, polygonInfo)) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private boolean isValidRectangle(Point point1, Point point2, PolygonInfo polygonInfo) {
        int minX = Math.min(point1.x(), point2.x());
        int maxX = Math.max(point1.x(), point2.x());
        int minY = Math.min(point1.y(), point2.y());
        int maxY = Math.max(point1.y(), point2.y());

        // check corners
        if (!isValidPoint(new Point(minX, minY), polygonInfo)) return false;
        if (!isValidPoint(new Point(minX, maxY), polygonInfo)) return false;
        if (!isValidPoint(new Point(maxX, minY), polygonInfo)) return false;
        if (!isValidPoint(new Point(maxX, maxY), polygonInfo)) return false;

        // check perimeter
        for (int x = minX; x <= maxX; x++) {
            if (!isValidPoint(new Point(x, minY), polygonInfo)) return false;
            if (!isValidPoint(new Point(x, maxY), polygonInfo)) return false;
        }

        for (int y = minY + 1; y < maxY; y++) {
            if (!isValidPoint(new Point(minX, y), polygonInfo)) return false;
            if (!isValidPoint(new Point(maxX, y), polygonInfo)) return false;
        }

        return true;
    }

    private boolean isValidPoint(Point point, PolygonInfo polygonInfo) {
        if (polygonInfo.lines().contains(point)) {
            return true;
        }
        return isInsidePolygon(point, polygonInfo.edges());
    }

    private PolygonInfo createPolygonInfo(List<Point> redTiles) {
        Set<Point> edges = new HashSet<>(redTiles);

        // Build edge lines
        for (int i = 0; i < redTiles.size(); i++) {
            // Fill in edges
            Point a = redTiles.get(i);
            Point b = redTiles.get((i + 1) % redTiles.size());
            if (a.x() == b.x()) {
                // vertical line
                for (int j = Math.min(a.y(), b.y()); j <= Math.max(a.y(), b.y()); j++) {
                    edges.add(new Point(a.x(), j));
                }
            } else if (a.y() == b.y()) {
                // horizontal line
                for (int j = Math.min(a.x(), b.x()); j <= Math.max(a.x(), b.x()); j++) {
                    edges.add(new Point(j, a.y()));
                }
            }
        }

        return new PolygonInfo(edges, redTiles);
    }

    public boolean isInsidePolygon(Point point, List<Point> polygon) {
        int crossings = 0;

        for (int i = 0; i < polygon.size(); i++) {
            Point a = polygon.get(i);
            Point b = polygon.get((i + 1) % polygon.size()); // Next point (wraps around)

            // Check if horizontal ray from point crosses edge a→b
            if ((a.y() > point.y()) != (b.y() > point.y())) {
                // Edge crosses the horizontal line through point
                // Calculate x-coordinate of intersection
                double atX = (b.x() - a.x()) * (point.y() - a.y()) / (double) (b.y() - a.y()) + a.x();
                if (point.x() < atX) {
                    crossings++;
                }
            }
        }

        // Odd number of crossings = inside
        return crossings % 2 == 1;
    }

    public long area(Point a, Point b) {

        long side1 = Math.max(a.x(), b.x()) - Math.min(a.x(), b.x()) + 1;
        long side2 = Math.max(a.y(), b.y()) - Math.min(a.y(), b.y()) + 1;
        return side1 * side2;
    }

    public record Point(int x, int y) {
    }

    public record PolygonInfo(Set<Point> lines, List<Point> edges) {
    }
}
