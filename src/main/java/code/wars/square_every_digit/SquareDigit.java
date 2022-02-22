package code.wars.square_every_digit;

import java.util.stream.Collectors;

public class SquareDigit {

    public int squareDigits(int n) {

        final String squaredNumbers = String.valueOf(n)
                .chars()
                .map(number -> number - 48)
                .map(number -> number * number)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        return Integer.parseInt(squaredNumbers);
    }
}
