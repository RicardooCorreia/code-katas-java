package code.wars.valid_parentheses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void validParentheses_whenOpensAndClose_returnTrue() {

        // Given
        final String input = "()";

        // When
        final boolean result = Solution.validParentheses(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void validParentheses_whenDoesNotClose_returnFalse() {

        // Given
        final String input = "())";

        // When
        final boolean result = Solution.validParentheses(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void validParentheses_whenValidAndHasCharacters_returnTrue() {

        // Given
        final String input = "32423(sgsdg)";

        // When
        final boolean result = Solution.validParentheses(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void validParentheses_whenDoesNotCloseAndHasCharacters_returnFalse() {

        // Given
        final String input = "(dsgdsg))2432";

        // When
        final boolean result = Solution.validParentheses(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void validParentheses_whenDoesNotHaveParentheses_returnTrue() {

        // Given
        final String input = "adasdasfa";

        // When
        final boolean result = Solution.validParentheses(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void validParentheses_whenHasTheSameNumberOfParenthesesButItsInTheWrongOrder_returnFalse() {

        // Given
        final String input = ")()()(";

        // When
        final boolean result = Solution.validParentheses(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}