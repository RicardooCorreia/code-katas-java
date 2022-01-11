package haker.rank.cavity_map;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    public static List<String> cavityMap(List<String> grid) {

        final char[][] cells = grid.stream()
                .map(String::toCharArray)
                .toList()
                .toArray(new char[0][0]);

        for (int i = 1; i < cells.length - 1; i++) {

            final char[] row = cells[i];
            for (int j = 1; j < row.length - 1; j++) {
                final char possibleCavity = cells[i][j];
                final boolean isBiggestOfColumn = possibleCavity > cells[i + 1][j] && possibleCavity > cells[i - 1][j];
                final boolean isBiggestOfRow = possibleCavity > cells[i][j + 1] && possibleCavity > cells[i][j - 1];
                if (isBiggestOfColumn && isBiggestOfRow) {
                    cells[i][j] = 'X';
                }
            }
        }

        return transform(cells);
    }

    private static List<String> transform(char[][] cells) {

        final List<char[]> chars = Arrays.asList(cells);
        return chars.stream()
                .map(String::valueOf)
                .toList();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(String.join("\n", result) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}

