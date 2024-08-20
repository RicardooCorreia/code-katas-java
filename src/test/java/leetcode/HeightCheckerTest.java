package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HeightCheckerTest {

    private final HeightChecker.Solution subject = new HeightChecker.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 4, 2, 1, 3}, 3),
                Arguments.arguments(new int[]{5, 1, 2, 3, 4}, 5),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void heightChecker(
        // Given
        int[] input,
        int expected) {

        // When
        int result = subject.heightChecker(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}