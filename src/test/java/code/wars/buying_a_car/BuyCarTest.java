package code.wars.buying_a_car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyCarTest {

    @Test
    void nbMonths_whenHasToSaveToGetCar_returnHowManyMonthsWithMoneyLeft() {

        // Given
        final int priceOldCar = 2000;
        final int priceNewCar = 8000;
        final int savingPerMonth = 1000;
        final double percentLossByMonth = 1.5;

        // When
        final int[] result = BuyCar.nbMonths(priceOldCar, priceNewCar, savingPerMonth, percentLossByMonth);

        // Then
        assertThat(result)
                .containsExactly(6, 766);
    }

    @Test
    void nbMonths_whenAlreadyHasMoneyForNewCar_returnZeroMonths() {

        // Given
        final int priceOldCar = 12000;
        final int priceNewCar = 8000;
        final int savingPerMonth = 1000;
        final double percentLossByMonth = 1.5;

        // When
        final int[] result = BuyCar.nbMonths(priceOldCar, priceNewCar, savingPerMonth, percentLossByMonth);

        // Then
        assertThat(result)
                .containsExactly(0, 4000);
    }
}
