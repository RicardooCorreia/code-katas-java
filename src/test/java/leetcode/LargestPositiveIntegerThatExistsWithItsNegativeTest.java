package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestPositiveIntegerThatExistsWithItsNegativeTest {

    private final LargestPositiveIntegerThatExistsWithItsNegative.Solution subject = new LargestPositiveIntegerThatExistsWithItsNegative.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{-1, 2, -3, 3}, 3),
                Arguments.arguments(new int[]{-1, 10, 6, 7, -7, 1}, 7),
                Arguments.arguments(new int[]{-10, 8, 6, 7, -2, -3}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findMaxK(
            // Given
            int[] nums,
            int expected) {

        // When
        int result = subject.findMaxK(nums);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}