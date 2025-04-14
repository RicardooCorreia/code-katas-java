package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountGoodTripletsTest {

    private final CountGoodTriplets.Solution subject = new CountGoodTriplets.Solution();

    @Test
    void countGoodTriplets_whenHasTriplets_returnExpected() {

        // Given
        int[] input = {3, 0, 1, 1, 9, 7};
        int a = 7;
        int b = 2;
        int c = 3;

        // When
        int result = subject.countGoodTriplets(input, a, b, c);

        // Then
        assertThat(result)
                .isEqualTo(4);
    }

    @Test
    void countGoodTriplets_whenHasNoTriplets_returnZero() {

        // Given
        int[] input = {1, 1, 2, 2, 3};
        int a = 0;
        int b = 0;
        int c = 1;

        // When
        int result = subject.countGoodTriplets(input, a, b, c);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}
