package code.wars.detect_pangram;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PangramCheckerTest {

    private final PangramChecker subject = new PangramChecker();

    @Test
    void check_whenSentenceUsesEveryLetterOfTheAlphabet_returnTrue() {

        // Given
        final String input = "The quick brown fox jumps over the lazy dog.";

        // When
        final boolean result = subject.check(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void check_whenSentenceDoesNotUseEveryLetterOfTheAlphabet_returnFalse() {

        // Given
        final String input = "You shall not pass!";

        // When
        final boolean result = subject.check(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void check_whenSentenceUsesEveryLetterOfTheAlphabetUpperAndLowerCase_returnTrue() {

        // Given
        final String input = "abcdefGhijkLmnopqrstUVwXyz";

        // When
        final boolean result = subject.check(input);

        // Then
        assertThat(result)
                .isTrue();
    }
}