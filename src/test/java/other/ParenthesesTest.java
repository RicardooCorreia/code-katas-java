package other;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParenthesesTest {

    private final Parentheses subject = new Parentheses();

    @Test
    void isBalanced_whenIsBalanced_returnTrue() {

        // Given
        String input = "((1+3)/2)*2";

        // When
        boolean result = subject.isBalanced(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void isBalanced_whenIsNotBalanced_returnFalse() {

        // Given
        String input = ")(1+3)";

        // When
        boolean result = subject.isBalanced(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void isBalanced_whenHasSameNumberOrParenthesesButIsNotValid_returnFalse() {

        // Given
        String input = "))(()(";

        // When
        boolean result = subject.isBalanced(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}
