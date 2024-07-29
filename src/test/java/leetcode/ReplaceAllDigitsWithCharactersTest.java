package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReplaceAllDigitsWithCharactersTest {

    private final ReplaceAllDigitsWithCharacters.Solution subject = new ReplaceAllDigitsWithCharacters.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("a1c1e1", "abcdef"),
                Arguments.arguments("a1b2c3d4e", "abbdcfdhe")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void replaceDigits(
            // Given
            String input,
            String expected) {

        // When
        String result = subject.replaceDigits(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}