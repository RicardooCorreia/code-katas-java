package code.wars.find_the_parity_outlier;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindOutlier {

    static int find(int[] integers) {

        if (integers.length < 3) {
            return 0;
        }

        final int firstNumber = integers[0];
        final int secondNumber = integers[1];
        final int thirdNumber = integers[2];

        final boolean firstIsEven = firstNumber % 2 == 0;
        final boolean secondIsEven = secondNumber % 2 == 0;
        final boolean thirdIsEven = thirdNumber % 2 == 0;

        if (allTrue(firstIsEven, secondIsEven, thirdIsEven)) {
            return findNumberMatching(integers, result -> result % 2 != 0);
        } else if (allFalse(firstIsEven, secondIsEven, thirdIsEven)) {
            return findNumberMatching(integers, result -> result % 2 == 0);
        } else {
            return findOutlierInFirstThreeNumbers(integers);
        }
    }

    private static int findOutlierInFirstThreeNumbers(int[] integers) {

        final Map<Boolean, List<Integer>> numbers = Arrays.stream(integers)
                .boxed()
                .limit(3)
                .collect(Collectors.groupingBy(integer -> integer % 2 == 0, Collectors.toUnmodifiableList()));

        final List<Integer> evenNumbers = numbers.get(true);
        final List<Integer> oddNumbers = numbers.get(false);

        if (evenNumbers.size() > oddNumbers.size()) {
            return oddNumbers.get(0);
        } else {
            return evenNumbers.get(0);
        }
    }

    private static int findNumberMatching(int[] integers, IntPredicate matchingCriteria) {

        return IntStream.of(integers)
                .skip(3)
                .filter(matchingCriteria)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No outlier found"));
    }

    private static boolean allTrue(Boolean... input) {

        return Arrays.stream(input)
                .allMatch(b -> b);
    }

    private static boolean allFalse(Boolean... input) {

        return Arrays.stream(input)
                .noneMatch(b -> b);
    }
}
