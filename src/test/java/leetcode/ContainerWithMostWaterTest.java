package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater.Solution subject = new ContainerWithMostWater.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.arguments(new int[]{1, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void maxArea(
            // Given
            int[] height,
            int expected) {

        // When
        int result = subject.maxArea(height);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}