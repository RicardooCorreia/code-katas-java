package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfSquaresOfSpecialElementsTest {

    private final SumOfSquaresOfSpecialElements.Solution subject = new SumOfSquaresOfSpecialElements.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4}, 21),
                Arguments.arguments(new int[]{2, 7, 1, 19, 18, 3}, 63)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void sumOfSquares(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.sumOfSquares(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}