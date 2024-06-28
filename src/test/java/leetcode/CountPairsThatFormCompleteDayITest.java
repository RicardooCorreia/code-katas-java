package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountPairsThatFormCompleteDayITest {

    private final CountPairsThatFormCompleteDayI.Solution subject = new CountPairsThatFormCompleteDayI.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{12, 12, 30, 24, 24}, 2),
                Arguments.arguments(new int[]{72, 48, 24, 3}, 3),
                Arguments.arguments(new int[]{12, 12, 5, 3}, 1),
                Arguments.arguments(new int[]{1, 2, 3, 4}, 0),
                Arguments.arguments(new int[]{21, 19, 3}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countCompleteDayPairs(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.countCompleteDayPairs(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}