package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumNumberGameTest {

    private final MinimumNumberGame.Solution subject = new MinimumNumberGame.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{5, 4, 2, 3}, new int[]{3, 2, 5, 4}),
                Arguments.arguments(new int[]{2, 5}, new int[]{5, 2})
        );
    }


    @ParameterizedTest
    @MethodSource("examples")
    void numberGame(
            // Given
            int[] input,
            int[] expected) {

        // When
        int[] result = subject.numberGame(input);

        // Then
        assertThat(result)
                .containsExactly(expected);
    }
}