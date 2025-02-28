package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumAbsoluteOfAnySubarrayTest {

    private final MaximumAbsoluteOfAnySubarray.Solution subject = new MaximumAbsoluteOfAnySubarray.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, -3, 2, 3, -4}, 5),
                Arguments.arguments(new int[]{2, -5, 1, -4, 3, -2}, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maxAbsoluteSum(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.maxAbsoluteSum(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void maxAbsoluteSum_whenSingleNumber_returnNumber() {

        // Given
        int[] nums = {1};

        // When
        int result = subject.maxAbsoluteSum(nums);

        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void maxAbsoluteSum_whenSmallSubset_returnNumber() {

        // Given
        int[] nums = {2, -1};

        // When
        int result = subject.maxAbsoluteSum(nums);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }
}