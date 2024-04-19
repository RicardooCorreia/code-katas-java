package code.wars.maximum_product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProductTest {

    private static final MaxProduct subject = new MaxProduct();

    @Test
    void adjacentElementsProduct_returnMaximumAdjacent() {

        // Given
        final int[] input = {3, 5, -2, -45, 0, 10, 5, 10};

        // When
        final int result = subject.adjacentElementsProduct(input);

        // Then
        assertThat(result)
                .isEqualTo(90);
    }
}
