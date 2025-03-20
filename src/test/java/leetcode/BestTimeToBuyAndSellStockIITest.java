package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeToBuyAndSellStockIITest {

    private final BestTimeToBuyAndSellStockII.Solution subject = new BestTimeToBuyAndSellStockII.Solution();

    @Test
    void maxProfit_whenCanHaveProfit_returnMaxProfit() {

        // Given
        int[] prices = {7, 1, 5, 3, 6, 4};

        // When
        int result = subject.maxProfit(prices);

        // Then
        assertThat(result)
                .isEqualTo(7);
    }

    @Test
    void maxProfit_whenCanHaveProfitMultipleWays_returnMaxProfit() {

        // Given
        int[] prices = {1, 2, 3, 4, 5};

        // When
        int result = subject.maxProfit(prices);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    void maxProfit_whenDoesNotHaveProfit_returnZero() {

        // Given
        int[] prices = {7, 6, 4, 3, 1};

        // When
        int result = subject.maxProfit(prices);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}