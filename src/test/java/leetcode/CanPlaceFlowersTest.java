package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {

    private final CanPlaceFlowers.Solution subject = new CanPlaceFlowers.Solution();

    @Test
    void canPlaceFlowers_whenCanPlace_returnTrue() {

        // Given
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;

        // When
        boolean result = subject.canPlaceFlowers(flowerbed, n);

        // Then
        assertTrue(result);
    }

    @Test
    void canPlaceFlowers_whenCannotPlace_returnFalse() {

        // Given
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;

        // When
        boolean result = subject.canPlaceFlowers(flowerbed, n);

        // Then
        assertFalse(result);
    }
}