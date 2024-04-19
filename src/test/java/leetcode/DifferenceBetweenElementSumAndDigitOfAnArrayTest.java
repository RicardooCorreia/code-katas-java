package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static leetcode.DifferenceBetweenElementSumAndDigitOfAnArray.Solution;
import static org.assertj.core.api.Assertions.assertThat;

class DifferenceBetweenElementSumAndDigitOfAnArrayTest {

    private final Solution subject = new Solution();

    public static Stream<Arguments> example() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 15, 6, 3}, 9),
                Arguments.arguments(new int[]{1, 2, 3, 4}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("example")
    void differenceOfSum(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.differenceOfSum(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}