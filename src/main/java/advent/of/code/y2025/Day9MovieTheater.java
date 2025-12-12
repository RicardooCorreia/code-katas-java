package advent.of.code.y2025;

import java.util.Arrays;
import java.util.List;

/*
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
 */
public class Day9MovieTheater {

    public long largestRectangleArea(String input) {

        List<Point> points = Arrays.stream(input.split("\\n"))
                .map(s -> s.split(","))
                .map(strings -> new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])))
                .toList();

        long maxArea = Long.MIN_VALUE;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point point1 = points.get(i);
                Point point2 = points.get(j);
                long area = area(point1, point2);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public long area(Point a, Point b) {

        long side1 = Math.max(a.x(), b.x()) - Math.min(a.x(), b.x()) + 1;
        long side2 = Math.max(a.y(), b.y()) - Math.min(a.y(), b.y()) + 1;
        return side1 * side2;
    }

    public record Point(int x, int y) {
    }
}
