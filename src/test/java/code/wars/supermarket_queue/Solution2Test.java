package code.wars.supermarket_queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2Test {

    @Test
    void solveSuperMarketQueue_whenJustOneCashier_returnSumOfTimes() {

        // Given
        final int[] customers = {5, 3, 4};
        final int cashiers = 1;

        // When
        final int result = Solution2.solveSuperMarketQueue(customers, cashiers);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }

    @Test
    void solveSuperMarketQueue_whenTwoCashiers_returnCorrectTime() {

        // Given
        // The second, third and forth people will finish before the first
        final int[] customers = {10, 2, 3, 3};
        final int cashiers = 2;

        // When
        final int result = Solution2.solveSuperMarketQueue(customers, cashiers);

        // Then
        assertThat(result)
                .isEqualTo(10);
    }

    @Test
    void solveSuperMarketQueue_whenTwoCashiersButHasLargeTimeForLast_returnCorrectTime() {

        // Given
        // The second, third and forth people will finish before the first
        final int[] customers = {2, 3, 10};
        final int cashiers = 2;

        // When
        final int result = Solution2.solveSuperMarketQueue(customers, cashiers);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }

    @Test
    public void solveSuperMarketQueue_whenHasManyCustomers_returnCorrectTime() {

        // Given
        final int[] customers = {2, 2, 3, 3, 4, 4};
        final int cashiers = 2;

        // When
        final int result = Solution2.solveSuperMarketQueue(customers, cashiers);

        // Then
        assertThat(result)
                .isEqualTo(9);
    }

    @Test
    public void solveSuperMarketQueue_whenMoreCashiersThanCustomers_returnMaxTime() {

        // Given
        final int[] customers = {1, 2, 3, 4};
        final int cashiers = 10;

        // When
        final int result = Solution2.solveSuperMarketQueue(customers, cashiers);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    public void solveSuperMarketQueue_whenEmpty_returnZero() {

        // Given
        final int[] customers = {};
        final int cashiers = 2;

        // When
        final int result = Solution2.solveSuperMarketQueue(customers, cashiers);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}
