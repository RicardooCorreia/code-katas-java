package code.wars.sort_the_odd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {


    public static Stream<Arguments> arrays() {

        return Stream.of(
                arguments(new int[]{5, 3, 2, 8, 1, 4}, new int[]{1, 3, 2, 8, 5, 4}),
                arguments(new int[]{5, 3, 1, 8, 0}, new int[]{1, 3, 5, 8, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("arrays")
    void sortArray_sortsOddNumbersAndKeepsEvenNumbersInOriginalPositions(
            // Given
            int[] input,
            int[] expected) {

        // When
        final int[] result = Kata.sortArray(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void sortArray_whenEmpty_returnsEmpty() {

        // Given
        final int[] input = {};

        // When
        final int[] result = Kata.sortArray(input);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{});
    }
}