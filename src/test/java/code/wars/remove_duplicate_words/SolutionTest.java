package code.wars.remove_duplicate_words;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void removeDuplicateWords_removeDuplicates() {

        // Given
        final String input = "alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta";

        // When
        final String result = Solution.removeDuplicateWords(input);

        // Then
        assertThat(result).isEqualTo("alpha beta gamma delta");
    }

    @Test
    void removeDuplicateWords_whenNoDuplicates_returnSameString() {

        // Given
        final String input = "my cat is fat";

        // When
        final String result = Solution.removeDuplicateWords(input);

        // Then
        assertThat(result).isEqualTo("my cat is fat");
    }
}
