package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseIntegerTest {

    private final ReverseInteger.Solution subject = new ReverseInteger.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(123, 321),
                Arguments.arguments(-123, -321),
                Arguments.arguments(120, 21)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void reverse(
            // Given
            int input,
            int expected) {

        // When
        int result = subject.reverse(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void reverse_whenOutsideRange_return0() {

        // Given
        int input = 1534236469;

        // Then
        int result = subject.reverse(input);

        // When
        assertThat(result)
                .isEqualTo(0);
    }
}