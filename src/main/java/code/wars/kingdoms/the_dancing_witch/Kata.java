package code.wars.kingdoms.the_dancing_witch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kata {

    public static String figureOut(String[] arr) {

        Map<String, Integer> positions = new HashMap<>();
        String[] letters = arr[0].split("");
        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            if (letter.isBlank()) {
                continue;
            }
            positions.put(letter, i);
        }

        String[] remainingPositions = getRemainingPositions(arr);
        return figureOut(remainingPositions, positions);
    }

    private static String figureOut(String[] arr, Map<String, Integer> previousPositions) {

        if (arr.length == 0) {
            return null;
        }
        Map<String, Integer> newPositions = new HashMap<>();
        String currentDancePositions = arr[0];
        String[] split = currentDancePositions.split("");

        for (int i = 0; i < split.length; i++) {
            String person = split[i];
            if (person.isBlank()) {
                continue;
            }

            int positionDifference = Math.abs(previousPositions.get(person) - i);
            if (positionDifference > 1) {
                return person;
            } else {
                newPositions.put(person, i);
            }
        }
        String[] remainingPositions = getRemainingPositions(arr);
        return figureOut(remainingPositions, newPositions);
    }

    private static String[] getRemainingPositions(String[] arr) {

        return Arrays.copyOfRange(arr, 1, arr.length);
    }
}
