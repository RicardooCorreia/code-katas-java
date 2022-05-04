package code.wars.get_the_middle_character;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void getMiddle_whenEven_returnTwoLetters() {

        // Given
        final String input = "middle";

        // When
        final String result = Kata.getMiddle(input);

        // Then
        assertThat(result)
                .isEqualTo("dd");
    }

    @Test
    public void getMiddle_whenOdd_returnSingleLetters() {

        // Given
        final String input = "testing";

        // When
        final String result = Kata.getMiddle(input);

        // Then
        assertThat(result)
                .isEqualTo("t");
    }

    @Test
    public void getMiddle_whenSingleLetter_returnLetter() {

        // Given
        final String input = "A";

        // When
        final String result = Kata.getMiddle(input);

        // Then
        assertThat(result)
                .isEqualTo("A");
    }
}
