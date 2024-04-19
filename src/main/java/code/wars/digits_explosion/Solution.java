package code.wars.digits_explosion;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static String explode(String digits) {

        return digits.chars()
                .mapToObj(operand -> operand - 48)
                .flatMap(value -> IntStream.range(0, value)
                        .map(operand -> value)
                        .boxed())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
