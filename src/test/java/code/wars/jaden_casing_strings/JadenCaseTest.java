package code.wars.jaden_casing_strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JadenCaseTest {

    private final JadenCase subject = new JadenCase();

    @Test
    void toJadenCase_capitalizesEveryWord() {

        // Given
        final String input = "How can mirrors be real if our eyes aren't real";

        // When
        final String result = subject.toJadenCase(input);

        // Then
        assertThat(result)
                .isEqualTo("How Can Mirrors Be Real If Our Eyes Aren't Real");
    }

    @Test
    void toJadenCase_whenIsNull_returnNull() {

        // Given
        final String input = null;

        // When
        final String result = subject.toJadenCase(input);

        // Then
        assertThat(result)
                .isNull();
    }

    @Test
    void toJadenCase_whenIsEmpty_returnNull() {

        // Given
        final String input = "";

        // When
        final String result = subject.toJadenCase(input);

        // Then
        assertThat(result)
                .isNull();
    }
}