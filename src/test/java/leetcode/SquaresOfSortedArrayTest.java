package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SquaresOfSortedArrayTest {

    private final SquaresOfSortedArray.Solution subject = new SquaresOfSortedArray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                Arguments.arguments(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sortedSquares_examples(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.sortedSquares(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}