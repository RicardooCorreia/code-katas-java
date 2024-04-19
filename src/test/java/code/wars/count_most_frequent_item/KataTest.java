package code.wars.count_most_frequent_item;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void mostFrequentItemCount_returnMostFrequent() {

        // Given
        int[] input = {3, -1, -1, -1, 2, 3, -1, 3, -1, 2, 4, 9, 3};

        // When
        int result = Kata.mostFrequentItemCount(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }
}
