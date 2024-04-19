package code.wars.pair_of_gloves;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void numberOfPairs_whenNoGloves_returnEmpty() {

        // Given
        String[] input = {};

        // When
        int result = Kata.numberOfPairs(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void numberOfPairs_whenFormsOnePair_return1Pair() {

        // Given
        String[] input = {"red", "red"};

        // When
        int result = Kata.numberOfPairs(input);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void numberOfPairs_whenMultipleGlovesAndMatch_returnCorrectPairs() {

        // Given
        String[] input = {"red", "green", "blue", "blue", "red", "green", "red", "red", "red"};

        // When
        int result = Kata.numberOfPairs(input);

        // Then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void numberOfPairs_whenMultipleGlovesButDontMatch_returnZeroPairs() {

        // Given
        String[] input = {"red", "green", "blue"};

        // When
        int result = Kata.numberOfPairs(input);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
