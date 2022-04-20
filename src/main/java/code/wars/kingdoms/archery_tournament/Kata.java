package code.wars.kingdoms.archery_tournament;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kata {
    public static String[] countAndSort(String[] target) {

        final int targetLength = target.length;
        int center = targetLength / 2;
        char[][] matrix = Arrays.stream(target)
                .map(String::toCharArray)
                .toArray(value -> new char[targetLength][targetLength]);

        final Map<Character, PlayerScore> pointsPerPlayer = new HashMap<>();

        final int matrixLength = matrix.length;
        for (int i = 0; i < matrixLength; i++) {
            final char[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                final char tile = row[j];
                if (tile != '*') {
                    final boolean isUpperCase = Character.isUpperCase(tile);
                    int multiplier = isUpperCase ? 2 : 1;
                    final int points = calculatePoints(i, j, center, matrixLength) * multiplier;
                    final char player = Character.toLowerCase(tile);
                    final PlayerScore currentPoints = pointsPerPlayer.getOrDefault(player, new PlayerScore(0, 0));
                    pointsPerPlayer.put(player, new PlayerScore(currentPoints.points() + points, currentPoints.arrows() + multiplier));
                }
            }
        }

        return pointsPerPlayer.entrySet()
                .stream()
                .sorted((player1, player2) -> {
                    final int pointsDiff = player1.getValue().points() - player2.getValue().points();
                    final int arrowDiff = player1.getValue().arrows() - player2.getValue().arrows();
                    if (pointsDiff != 0) {
                        return pointsDiff;
                    } else if (arrowDiff != 0) {
                        return -arrowDiff;
                    } else {
                        return player1.getKey().compareTo(player2.getKey());
                    }
                })
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .toArray(value -> new String[pointsPerPlayer.size()]);
    }

    private static int calculatePoints(int i, int j, int center, int matrixLength) {

        int columnPoints = i > center ? matrixLength - i - 1 : i;
        int rowPoints = j > center ? matrixLength - j - 1 : j;
        return Math.min(columnPoints, rowPoints) + 1;
    }

    private record PlayerScore(int points, int arrows) {
    }
}
