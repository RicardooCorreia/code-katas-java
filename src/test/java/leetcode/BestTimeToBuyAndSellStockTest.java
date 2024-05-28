package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeToBuyAndSellStockTest {

    private final BestTimeToBuyAndSellStock.Solution subject = new BestTimeToBuyAndSellStock.Solution();

    @Test
    void maxProfit_whenHasProfit_returnProfit() {

        // Given
        int[] input = {7, 1, 5, 3, 6, 4};

        // When
        int result = subject.maxProfit(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }

    @Test
    void maxProfit_whenHasSmallProfit_returnProfit() {

        // Given
        int[] input = {2, 4, 1};

        // When
        int result = subject.maxProfit(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void maxProfit_whenHasTwoPossibleProfit_returnHigherProfit() {

        // Given
        int[] input = {7, 2, 5, 1, 6, 4};

        // When
        int result = subject.maxProfit(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }

    @Test
    void maxProfit_whenDoesNotHaveProfit_returnZero() {

        // Given
        int[] input = {7, 6, 4, 3, 1};

        // When
        int result = subject.maxProfit(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}