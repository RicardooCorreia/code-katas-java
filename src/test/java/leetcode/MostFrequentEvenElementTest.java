package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MostFrequentEvenElementTest {

    private final MostFrequentEvenElement.Solution subject = new MostFrequentEvenElement.Solution();

    @Test
    void mostFrequentEven_whenHasMultiple_returnSmallest() {

        // Given
        int[] input = {0, 1, 2, 2, 4, 4, 1};

        // When
        int result = subject.mostFrequentEven(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void mostFrequentEven_whenHasEven_returnNumber() {

        // Given
        int[] input = {4, 4, 4, 9, 2, 4};

        // When
        int result = subject.mostFrequentEven(input);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    void mostFrequentEven_whenHasNoEvenNumber_returnMinusOne() {

        // Given
        int[] input = {29, 47, 21, 41, 13, 37, 25, 7};

        // When
        int result = subject.mostFrequentEven(input);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}