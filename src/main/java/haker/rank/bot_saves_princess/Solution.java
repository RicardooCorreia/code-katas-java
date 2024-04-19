package haker.rank.bot_saves_princess;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static List<String> displayPathToPrincess(int n, String[] grid) {

        int princessX = 0;
        int princessY = 0;

        int botX = 0;
        int botY = 0;

        for (int x = 0; x < grid.length; x++) {
            final char[] pointsInRow = grid[x].toCharArray();
            for (int y = 0; y < pointsInRow.length; y++) {
                if (pointsInRow[y] == 'p') {
                    princessX = x;
                    princessY = y;
                } else if (pointsInRow[y] == 'm') {
                    botX = x;
                    botY = y;
                }
            }
        }


        final int horizontalDiff = princessY - botY;
        final int verticalDiff = princessX - botX;

        final Stream<String> horizontalStream = getInstructionStream(horizontalDiff, "UP", "DOWN");
        final Stream<String> verticalStream = getInstructionStream(verticalDiff, "LEFT", "RIGHT");

        return Stream.concat(horizontalStream, verticalStream)
                .toList();
    }

    private static Stream<String> getInstructionStream(int diff,
                                                       String positiveDiffInstruction,
                                                       String negativeDiffInstruction) {

        if (diff == 0) {
            return Stream.empty();
        }

        final String instruction = diff > 0 ? positiveDiffInstruction : negativeDiffInstruction;
        return Stream.generate(() -> instruction)
                .limit(Math.abs(diff));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for (int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        final List<String> strings = displayPathToPrincess(m, grid);
        strings.forEach(System.out::println);
    }
}
