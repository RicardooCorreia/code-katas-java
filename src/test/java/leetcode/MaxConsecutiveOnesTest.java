package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxConsecutiveOnesTest {

    private final MaxConsecutiveOnes.Solution subject = new MaxConsecutiveOnes.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 0, 1, 1, 1}, 3),
                Arguments.arguments(new int[]{1, 0, 1, 1, 0, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findMaxConsecutiveOnes(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.findMaxConsecutiveOnes(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void findMaxConsecutiveOnes_whenNoElements_return0() {

        // Given
        int[] input = {0};

        // When
        int result = subject.findMaxConsecutiveOnes(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}