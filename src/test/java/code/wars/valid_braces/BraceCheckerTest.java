package code.wars.valid_braces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BraceCheckerTest {

    private final BraceChecker subject = new BraceChecker();

    @Test
    public void isValid_whenBracesAreClosed_returnTrue() {

        // Given
        final String input = "([{}])";

        // When
        final boolean result = subject.isValid(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    public void isValid_whenBracesAreOpen_returnFalse() {

        // Given
        final String input = "[({})](]";

        // When
        final boolean result = subject.isValid(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    public void isValid_whenBracesAreOutOfOrder_returnFalse() {

        // Given
        final String input = "[(])";

        // When
        final boolean result = subject.isValid(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    public void isValid_whenAllBracesAreOpen_returnFalse() {

        // Given
        final String input = "(((((((((";

        // When
        final boolean result = subject.isValid(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}
