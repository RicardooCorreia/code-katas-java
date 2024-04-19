package code.wars.frog_jumping;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FrogJumpingTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{1, 2, 2, -1}, 4),
                arguments(new int[]{1, 2, 1, 5}, 3),
                arguments(new int[]{1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1}, 9),
                arguments(new int[]{1, 2, 3, 1, -2, 1}, 6),
                arguments(new int[]{1, 1, 1, 1}, 4),
                arguments(new int[]{-1, -1, -2}, 1),
                arguments(new int[]{-3}, 1),
                arguments(new int[]{1, -1}, -1),
                arguments(new int[]{1, 2, 1, 2, -3, -4}, -1),
                arguments(new int[]{1, 0, 2}, -1));
    }

    @Test
    void solution_whenCanJumpOut_returnNumberOfJumps() {

        // Given
        int[] input = {1, 2, 1, 5};

        // When
        int result = FrogJumping.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void solution_whenInfiniteLoop_returnMinus1() {

        // Given
        int[] input = {1, -1, 1, 5};

        // When
        int result = FrogJumping.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void solution_baseTests(
            // Given
            int[] input,
            int expected) {

        // When
        int result = FrogJumping.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
