package code.wars.tribonacci_sequence;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class XbonacciTest {

    private final Xbonacci subject = new Xbonacci();

    public static Stream<Arguments> input() {

        return Stream.of(
                arguments(new double[]{1, 1, 1}, 10, new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}),
                arguments(new double[]{0, 0, 1}, 10, new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}),
                arguments(new double[]{0, 1, 1}, 10, new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81})
        );
    }

    @Test
    void tribonacci_whenIsZero_returnEmpty() {

        // Given
        final double[] numbers = new double[0];
        final int n = 0;

        // When
        final double[] result = subject.tribonacci(numbers, n);

        // Then
        assertThat(result)
                .isEqualTo(new double[0]);
    }

    @Test
    void tribonacci_whenNeedsToCalculateLargeNumber_doesNotThrowStackOverflow() {

        // Given
        final double[] numbers = new double[]{1, 1, 1};
        final int n = 9999;

        // When
        final ThrowableAssert.ThrowingCallable callable = () -> subject.tribonacci(numbers, n);

        // Then
        assertThatCode(callable)
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("input")
    void tribonacci_whenValid_returnCorrectNumbers(
            // Given
            double[] numbers,
            int n,
            double[] expected) {

        // When
        final double[] result = subject.tribonacci(numbers, n);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}