package code.wars.range_extraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> numbers() {

        return Stream.of(
                arguments(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}, "-6,-3-1,3-5,7-11,14,15,17-20"),
                arguments(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}, "-3--1,2,10,15,16,18-20")
        );
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void rangeExtraction_whenHasRange_returnCorrectString(
            // Given
            int[] input,
            String expected
    ) {

        // When
        final String result = Solution.rangeExtraction(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void rangeExtraction_whenIsContinuous_returnSingleRange() {

        // Given
        final int[] input = {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6};

        // When
        final String result = Solution.rangeExtraction(input);

        // Then
        assertThat(result)
                .isEqualTo("-3-6");
    }
}