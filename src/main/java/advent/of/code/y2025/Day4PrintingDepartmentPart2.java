package advent.of.code.y2025;

import java.util.Arrays;
import java.util.Objects;

/*
https://adventofcode.com/2025/day/4
--- Day 4: Printing Department ---
You ride the escalator down to the printing department. They're clearly getting ready for Christmas; they have lots of large rolls of paper everywhere, and there's even a massive printer in the corner (to handle the really big print jobs).

Decorating here will be easy: they can make their own decorations. What you really need is a way to get further into the North Pole base while the elevators are offline.

"Actually, maybe we can help with that," one of the Elves replies when you ask for help. "We're pretty sure there's a cafeteria on the other side of the back wall. If we could break through the wall, you'd be able to keep moving. It's too bad all of our forklifts are so busy moving those big rolls of paper around."

If you can optimize the work the forklifts are doing, maybe they would have time to spare to break through the wall.

The rolls of paper (@) are arranged on a large grid; the Elves even have a helpful diagram (your puzzle input) indicating where everything is located.

For example:

..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.
The forklifts can only access a roll of paper if there are fewer than four rolls of paper in the eight adjacent positions. If you can figure out which rolls of paper the forklifts can access, they'll spend less time looking and more time breaking down the wall to the cafeteria.

In this example, there are 13 rolls of paper that can be accessed by a forklift (marked with x):

..xx.xx@x.
x@@.@.@.@@
@@@@@.x.@@
@.@@@@..@.
x@.@@@@.@x
.@@@@@@@.@
.@.@.@.@@@
x.@@@.@@@@
.@@@@@@@@.
x.x.@@@.x.
Consider your complete diagram of the paper roll locations. How many rolls of paper can be accessed by a forklift?
 */
public class Day4PrintingDepartmentPart2 {

    public int accessibleRollsOfPaper(String input) {

        String[][] matrix = Arrays.stream(input.split("\\n"))
                .map(s -> s.split(""))
                .toArray(String[][]::new);
        int removed, totalRemoved = 0;
        do {
            removed = removeRolls(matrix);
            totalRemoved += removed;
        } while (removed != 0);
        return totalRemoved;
    }

    private static int removeRolls(String[][] matrix) {
        int accessible = 0;
        for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
            String[] line = matrix[lineIndex];
            for (int columnIndex = 0; columnIndex < line.length; columnIndex++) {

                if (isRoll(line[columnIndex])) {
                    int rollCount = 0;

                    int leftColumnIndex = columnIndex - 1;
                    int rightColumnIndex = columnIndex + 1;
                    int topLineIndex = lineIndex - 1;
                    int bottomLineIndex = lineIndex + 1;

                    boolean hasSpaceLeft = leftColumnIndex >= 0;
                    boolean hasSpaceRight = rightColumnIndex < line.length;
                    boolean hasSpaceTop = topLineIndex >= 0;
                    boolean hasSpaceBottom = bottomLineIndex < matrix.length;

                    String[] topLine = hasSpaceTop ? matrix[topLineIndex] : new String[0];
                    String[] bottomLine = hasSpaceBottom ? matrix[bottomLineIndex] : new String[0];
                    if (hasSpaceLeft) {
                        if (isRoll(line[leftColumnIndex])) {
                            rollCount++;
                        }
                        if (hasSpaceTop && isRoll(topLine[columnIndex - 1])) {
                            rollCount++;
                        }
                        if (hasSpaceBottom && isRoll(bottomLine[columnIndex - 1])) {
                            rollCount++;
                        }
                    }
                    if (hasSpaceRight) {
                        if (isRoll(line[rightColumnIndex])) {
                            rollCount++;
                        }
                        if (hasSpaceTop && isRoll(topLine[columnIndex + 1])) {
                            rollCount++;
                        }
                        if (hasSpaceBottom && isRoll(bottomLine[columnIndex + 1])) {
                            rollCount++;
                        }
                    }
                    if (hasSpaceTop && isRoll(topLine[columnIndex])) {
                        rollCount++;
                    }
                    if (hasSpaceBottom && isRoll(bottomLine[columnIndex])) {
                        rollCount++;
                    }

                    if (rollCount < 4) {
                        accessible++;
                        matrix[lineIndex][columnIndex] = "."; // remove
                    }
                }
            }
        }
        return accessible;
    }

    private static boolean isRoll(String line) {
        return Objects.equals(line, "@");
    }
}
