package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

class KeyboardRowTest {

    private KeyboardRow.Solution subject = new KeyboardRow.Solution();

    @Test
    void findWords_hasWordsThatCanBeTypedWithOneRow_returnWords() {

        // Given
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};

        // When
        String[] result = subject.findWords(words);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("Alaska", "Dad");

    }

    @Test
    void findWords_whenHasNoWordsThatCanBeTypedWithOneRow_returnEmpty() {

        // Given
        String[] words = {"omk"};

        // When
        String[] result = subject.findWords(words);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void findWords_whenAllWordsCanBeTypedWithOneRow_returnAll() {

        // Given
        String[] words = {"adsdf", "sfd"};

        // When
        String[] result = subject.findWords(words);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("adsdf", "sfd");
    }
}