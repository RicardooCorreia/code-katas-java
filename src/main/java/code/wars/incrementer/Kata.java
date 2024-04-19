package code.wars.incrementer;

import java.util.stream.IntStream;

public class Kata {

    public static int[] incrementer(int[] numbers) {

        return IntStream.rangeClosed(0, numbers.length - 1)
                .map(operand -> numbers[operand] + operand + 1)
                .map(operand -> operand % 10)
                .toArray();
    }
}
