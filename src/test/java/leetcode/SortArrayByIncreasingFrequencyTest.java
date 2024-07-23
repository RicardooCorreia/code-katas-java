package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortArrayByIncreasingFrequencyTest {

    private final SortArrayByIncreasingFrequency.Solution subject = new SortArrayByIncreasingFrequency.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 2, 2, 2, 3}, new int[]{3, 1, 1, 2, 2, 2}),
                Arguments.arguments(new int[]{2, 3, 1, 3, 2}, new int[]{1, 3, 3, 2, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void frequencySort(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.frequencySort(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}