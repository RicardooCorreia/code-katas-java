package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreOfStringTest {

    private final ScoreOfString.Solution subject = new ScoreOfString.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("hello", 13),
                Arguments.arguments("zaz", 50)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void scoreOfString(
            // Given
            String input,
            int expected) {

        // When
        int result = subject.scoreOfString(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}