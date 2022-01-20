package code.wars.stop_gninnips_my_sdrow;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpinWordsTest {

    private final SpinWords subject = new SpinWords();

    @Test
    void spinWords_whenHasWordsBiggerThan5_reverseWords() {

        // Given
        final String sentence = "Hey fellow warriors";

        // When
        final String result = subject.spinWords(sentence);

        // Then
        assertThat(result)
                .isEqualTo("Hey wollef sroirraw");
    }

    @Test
    void spinWords_whenWordsAreSmallerThan5_returnOriginalWords() {

        // Given
        final String sentence = "This is a test";

        // When
        final String result = subject.spinWords(sentence);

        // Then
        assertThat(result)
                .isEqualTo(sentence);
    }
}