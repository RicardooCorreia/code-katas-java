package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LengthOfLastWordTest {

    private final LengthOfLastWord.Solution subject = new LengthOfLastWord.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments("Hello World", 5),
                Arguments.arguments("luffy is still joyboy", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void lengthOfLastWord(
            // Given
            String input,
            int expected
    ) {

        // When
        int result = subject.lengthOfLastWord(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void lengthOfLastWord_whenHasSpaces_returnCorrectResult() {

        // Given
        String input = "   fly me   to   the moon  ";

        // When
        int result = subject.lengthOfLastWord(input);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }
}