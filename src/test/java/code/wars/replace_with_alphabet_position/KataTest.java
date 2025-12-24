package code.wars.replace_with_alphabet_position;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of("The sunset sets at twelve o' clock.", "20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11"),
                Arguments.of("Hello, World!", "8 5 12 12 15 23 15 18 12 4")
        );
    }

    @Test
    void alphabetPosition_base() {

        // Given
        String input = "a b c";

        // When
        String result = Kata.alphabetPosition(input);

        // Then
        assertThat(result)
                .isEqualTo("1 2 3");
    }

    @Test
    void alphabetPosition_whenUpperCase_returnCorrect() {

        // Given
        String input = "A B C";

        // When
        String result = Kata.alphabetPosition(input);

        // Then
        assertThat(result)
                .isEqualTo("1 2 3");
    }

    @Test
    void alphabetPosition_addsSpaces() {

        // Given
        String input = "abc";

        // When
        String result = Kata.alphabetPosition(input);

        // Then
        assertThat(result)
                .isEqualTo("1 2 3");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void alphabetPosition_whenEmpty_returnEmpty(
            // Given
            String input) {

        // When
        String result = Kata.alphabetPosition(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }

    @ParameterizedTest
    @MethodSource("examples")
    void alphabetPosition_examples(
            // Given
            String input,
            String expected
    ) {

        // When
        String result = Kata.alphabetPosition(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "!@#$%^&*()"})
    void alphabetPosition_whenNonAlphabetic_returnEmpty(
            // Given
            String input) {

        // When
        String result = Kata.alphabetPosition(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}
