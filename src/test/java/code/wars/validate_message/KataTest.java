package code.wars.validate_message;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void isAValidMessage_whenIsValidAndHasMultipleWords_returnTrue() {

        // Given
        final String input = "3hey5hello2hi";

        // When
        final boolean result = Kata.isAValidMessage(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isAValidMessage_whenIsValidAndHasLargeWord_returnTrue() {

        // Given
        final String input = "4code13hellocodewars";

        // When
        final boolean result = Kata.isAValidMessage(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isAValidMessage_whenIsNotValidPattern_returnFalse() {

        // Given
        final String input = "code4hello5";

        // When
        final boolean result = Kata.isAValidMessage(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isAValidMessage_whenIsNotValidNumber_returnFalse() {

        // Given
        final String input = "3hey5hello4hi";

        // When
        final boolean result = Kata.isAValidMessage(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isAValidMessage_whenIsEmpty_returnTrue() {

        // Given
        final String input = "";

        // When
        final boolean result = Kata.isAValidMessage(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isAValidMessage_whenIsZero_returnTrue() {

        // Given
        final String input = "0";

        // When
        final boolean result = Kata.isAValidMessage(input);

        // Then
        assertThat(result)
                .isTrue();
    }
}
