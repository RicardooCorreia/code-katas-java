package code.wars.positions_average;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PositionAverage {

    public static double posAverage(String input) {

        final String[] numbers = input.split(", ");
        final List<Combination> combinations = generateCombinations(numbers);

        final double totalPositions = combinations.size() * numbers[0].length();
        final int commonPositions = combinations.stream()
                .mapToInt(combination -> getCommonPositions(combination.string1(), combination.string2()))
                .sum();

        return ((double) commonPositions / totalPositions) * 100;
    }

    private static int getCommonPositions(String string1, String string2) {

        int commonPositions = 0;
        for (int k = 0; k < string1.length(); k++) {
            if (Objects.equals(string1.charAt(k), string2.charAt(k))) {
                commonPositions++;
            }
        }
        return commonPositions;
    }

    private static List<Combination> generateCombinations(String[] numbers) {
        final List<int[]> combinations = new ArrayList<>();
        int[] data = new int[2];
        int start = 0, index = 0;
        int end = numbers.length - 1;

        generateCombinations(combinations, data, start, end, index);
        return combinations.stream()
                .map(indexCombination -> new Combination(numbers[indexCombination[0]], numbers[indexCombination[1]]))
                .collect(Collectors.toList());
    }

    private static void generateCombinations(List<int[]> combinations, int[] data, int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            generateCombinations(combinations, data, start + 1, end, index + 1);
            generateCombinations(combinations, data, start + 1, end, index);
        }
    }

    private record Combination(String string1, String string2) {
    }

}
