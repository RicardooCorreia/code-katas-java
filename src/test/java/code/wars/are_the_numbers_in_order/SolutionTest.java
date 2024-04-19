package code.wars.are_the_numbers_in_order;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void isAscOrder_whenAscendingOrder_returnTrue() {

        // Given
        final int[] input = {1, 4, 13, 97, 508, 1047, 20058};

        // When
        final boolean result = Solution.isAscOrder(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    public void isAscOrder_whenNotAscendingOrder_returnFalse() {

        // Given
        final int[] input = {56, 98, 123, 67, 742, 1024, 32, 90969};

        // When
        final boolean result = Solution.isAscOrder(input);

        // Then
        assertThat(result)
                .isFalse();
    }
}
