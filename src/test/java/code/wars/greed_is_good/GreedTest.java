package code.wars.greed_is_good;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreedTest {

    @Test
    public void greedy_whenSingleNumbers_returnCorrectResult() {

        // Given
        int[] input = new int[]{5,1,3,4,1};

        // When
        int result = Greed.greedy(input);

        // Then
        assertThat(result)
                .isEqualTo(250);
    }

    @Test
    public void greedy_whenHasCombination_returnCorrectResult() {

        // Given
        int[] input = new int[]{1, 1, 1, 3, 1};

        // When
        int result = Greed.greedy(input);

        // Then
        assertThat(result)
                .isEqualTo(1100);
    }

    @Test
    public void greedy_whenHasCombinationAndSingleNumber_returnCorrectResult() {

        // Given
        int[] input = new int[]{2, 4, 4, 5, 4};

        // When
        int result = Greed.greedy(input);

        // Then
        assertThat(result)
                .isEqualTo(450);
    }
}
