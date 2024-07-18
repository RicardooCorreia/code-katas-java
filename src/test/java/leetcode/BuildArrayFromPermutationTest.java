package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BuildArrayFromPermutationTest {

    private BuildArrayFromPermutation.Solution subject = new BuildArrayFromPermutation.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{0, 2, 1, 5, 3, 4}, new int[]{0, 1, 2, 4, 5, 3}),
                Arguments.arguments(new int[]{5, 0, 1, 2, 3, 4}, new int[]{4, 5, 0, 1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void buildArray(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.buildArray(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}