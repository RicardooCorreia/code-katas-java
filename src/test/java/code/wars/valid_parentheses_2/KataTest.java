package code.wars.valid_parentheses_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "()",
            "((()))",
            "()()()",
            "(()())()",
            "()(())((()))(())()"})
    void validParentheses_whenIsValid_returnTrue(
            // Given
            String input) {

        // When
        boolean result = Kata.validParentheses(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            ")(",
            "()()(",
            "((())",
            "())(()",
            ")()",
            ")"})
    void validParentheses_whenIsInvalid_returnFalse(
            // Given
            String input) {

        // When
        boolean result = Kata.validParentheses(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void validParentheses_whenEmpty_returnTrue() {

        // Given
        String input = "";

        // When
        boolean result = Kata.validParentheses(input);

        // Then
        assertThat(result)
                .isTrue();
    }
}
