package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumWidthRampTest {

    private final MaximumWidthRamp.Solution subject = new MaximumWidthRamp.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{6, 0, 8, 2, 1, 5}, 4),
                Arguments.arguments(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maxWidthRamp_whenCorrect_returnTrue(
            // Given
            int[] nums,
            int expected) {

        // When
        int result = subject.maxWidthRamp(nums);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}