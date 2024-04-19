package code.wars.money_money_money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    void calculateYears_whenCanReachInThreeYears_returnThreeYears() {

        // Given
        double initial = 1000;
        double interest = 0.05;
        double tax = 0.18;
        double desired = 1100;

        // When
        int result = Money.calculateYears(initial, interest, tax, desired);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void calculateYears_whenLowInterest_returnLongerTime() {

        // Given
        double initial = 1000;
        double interest = 0.01625;
        double tax = 0.18;
        double desired = 1200;

        // When
        int result = Money.calculateYears(initial, interest, tax, desired);

        // Then
        assertThat(result)
                .isEqualTo(14);
    }

    @Test
    void calculateYears_whenAlreadyHas_returnZero() {

        // Given
        double initial = 1000;
        double interest = 0.05;
        double tax = 0.18;
        double desired = 1000;

        // When
        int result = Money.calculateYears(initial, interest, tax, desired);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}
