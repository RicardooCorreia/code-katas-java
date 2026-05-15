package code.wars.sum_of_two_lowest_positive_integers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.sum_of_two_lowest_positive_integers.Kata.sumTwoSmallestNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    static Stream<Arguments> testScenarios() {
        return Stream.of(
                arguments(new long[]{5, 8, 12, 19, 22}, 13L),
                arguments(new long[]{15, 28, 4, 2, 43}, 6L),
                arguments(new long[]{3, 87, 3, 12, 7}, 6L),
                arguments(new long[]{23, 71, 33, 82, 1}, 24L),
                arguments(new long[]{52, 76, 14, 12, 4}, 16L)
        );
    }

    @ParameterizedTest(name = "numbers={0} -> {1}")
    @MethodSource("testScenarios")
    void sumsTwoLowestPositiveIntegers(
        // given
        long[] numbers, long expected) {

        // when
        var result = sumTwoSmallestNumbers(numbers);

        // then
        assertThat(result).isEqualTo(expected);
    }
}