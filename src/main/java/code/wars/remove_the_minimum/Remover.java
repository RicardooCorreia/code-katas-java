package code.wars.remove_the_minimum;

import java.util.Arrays;

public class Remover {

    public static int[] removeSmallest(int[] numbers) {

        if (numbers.length == 0) {
            return new int[0];
        }

        int min = Arrays.stream(numbers)
                .min()
                .getAsInt();

        int[] result = new int[numbers.length - 1];
        boolean removed = false;
        int iterationIndex = 0;
        int insertIndex = 0;
        while (iterationIndex < numbers.length) {
            int number = numbers[iterationIndex];
            if (!removed && number == min) {
                removed = true;
            } else {
                result[insertIndex] = number;
                insertIndex++;
            }
            iterationIndex++;
        }

        return result;
    }
}
