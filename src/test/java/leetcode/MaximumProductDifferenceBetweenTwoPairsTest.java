package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumProductDifferenceBetweenTwoPairsTest {

    private final MaximumProductDifferenceBetweenTwoPairs.Solution subject = new MaximumProductDifferenceBetweenTwoPairs.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{5, 6, 2, 7, 4}, 34),
                Arguments.arguments(new int[]{4, 2, 5, 9, 7, 4, 8}, 64)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maxProductDifference(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.maxProductDifference(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}