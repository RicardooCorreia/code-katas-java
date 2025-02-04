package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumAscendingSubarraySumTest {

    private final MaximumAscendingSubarraySum.Solution subject = new MaximumAscendingSubarraySum.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{10, 20, 30, 5, 10, 50}, 65),
                Arguments.arguments(new int[]{10, 20, 30, 40, 50}, 150),
                Arguments.arguments(new int[]{12, 17, 15, 13, 10, 11, 12}, 33)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maxAscendingSum(
            // Given
            int[] nums,
            int expected) {

        // When
        int result = subject.maxAscendingSum(nums);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}