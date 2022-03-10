package code.wars.find_the_missing_letter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void findMissingLetter_whenMissingLetterIsLowerCase_returnLetter() {

        // Given
        final char[] input = {'a', 'b', 'c', 'd', 'f'};

        // When
        final char result = Kata.findMissingLetter(input);

        // Then
        assertThat(result)
                .isEqualTo('e');
    }

    @Test
    void findMissingLetter_whenMissingLetterIsUpperCase_returnLetter() {

        // Given
        final char[] input = {'O','Q','R','S'};

        // When
        final char result = Kata.findMissingLetter(input);

        // Then
        assertThat(result)
                .isEqualTo('P');
    }
}
