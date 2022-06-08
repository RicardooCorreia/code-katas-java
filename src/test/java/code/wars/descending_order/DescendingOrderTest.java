package code.wars.descending_order;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DescendingOrderTest {

    @Test
    public void sortDesc_whenZero_returnZero() {

        // Given
        int input = 0;

        // When
        int result = DescendingOrder.sortDesc(input);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void sortDesc_whenSmallNumber_returnDescendingOrder() {

        // Given
        int input = 15;

        // When
        int result = DescendingOrder.sortDesc(input);

        // Then
        assertThat(result).isEqualTo(51);
    }


    @Test
    public void sortDesc_whenLargerNumber_returnDescendingOrderCorrectly() {

        // Given
        int input = 123456789;

        // When
        int result = DescendingOrder.sortDesc(input);

        // Then
        assertThat(result).isEqualTo(987654321);
    }
}
