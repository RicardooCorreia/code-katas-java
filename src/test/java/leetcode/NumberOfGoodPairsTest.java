package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfGoodPairsTest {

    private final NumberOfGoodPairs.Solution subject = new NumberOfGoodPairs.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 1, 1, 3}, 4),
                Arguments.arguments(new int[]{1, 1, 1, 1}, 6),
                Arguments.arguments(new int[]{1, 2, 3}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void numIdenticalPairs(
            // Given
            int[] input, int expected) {

        // When
        int result = subject.numIdenticalPairs(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}