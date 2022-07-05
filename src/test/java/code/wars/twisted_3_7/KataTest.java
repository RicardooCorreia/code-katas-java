package code.wars.twisted_3_7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new Integer[]{1, 2, 7, 4, 5, 6, 3, 8, 9}),
                arguments(new Integer[]{12, 13, 14}, new Integer[]{12, 14, 13}),
                arguments(new Integer[]{9, 2, 4, 7, 3}, new Integer[]{2, 7, 4, 3, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void sortTwisted37_baseTests(
            // Given
            Integer[] input,
            Integer[] expected) {

        // When
        final Integer[] result = Kata.sortTwisted37(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void sortTwisted37_whenHasBoth3And7_returnCorrectSort() {

        // Given
        final Integer[] input = {137, 173, 3, 7, 0, 212};

        // When
        final Integer[] result = Kata.sortTwisted37(input);

        // Then
        assertThat(result)
                .containsExactly(0, 7, 3, 173, 137, 212);
    }
}
