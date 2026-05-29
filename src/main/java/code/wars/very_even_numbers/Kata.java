package code.wars.very_even_numbers;

import static java.util.Arrays.stream;

public class Kata {

    public static boolean isVeryEvenNumber(int number) {

        if (number < 10) {
            return number % 2 == 0;
        }

        final var string = String.valueOf(number);
        final var sum = stream(string.split(""))
            .mapToInt(Integer::parseInt)
            .sum();
        return isVeryEvenNumber(sum);
    }
}
