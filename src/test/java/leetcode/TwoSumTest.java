package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}));
    }

    @ParameterizedTest
    @MethodSource("examples")
    void twoSum_examples(
            // Given
            int[] input,
            int target,
            int[] expected) {

        // When
        int[] result = TwoSum.Solution.twoSum(input, target);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(expected);
    }

    @Test
    void twoSum_whenEmpty_returnEmpty() {

        // Given
        int[] input = new int[0];
        int target = 0;

        // When
        int[] result = TwoSum.Solution.twoSum(input, target);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void twoSum_whenNoSolution_returnEmpty() {

        // Given
        int[] input = new int[]{1, 2, 3};
        int target = 10;

        // When
        int[] result = TwoSum.Solution.twoSum(input, target);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void twoSum_whenNull_returnEmpty() {

        // Given
        int[] input = null;
        int target = 10;

        // When
        int[] result = TwoSum.Solution.twoSum(input, target);

        // Then
        assertThat(result)
                .isEmpty();
    }
}