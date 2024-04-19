package code.wars.driving_circles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    public void tour_whenIsPossible_returnStart() {

        // Given
        int[] petrol = {4, 3, 5};
        int[] distance = {4, 6, 1};

        // When
        int result = Main.tour(petrol, distance);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    public void tour_whenIsPossibleAndHasMoreStops_returnStart() {

        // Given
        int[] petrol = {4, 3, 5, 2, 6, 7};
        int[] distance = {4, 6, 1, 3, 5, 2};

        // When
        int result = Main.tour(petrol, distance);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    public void tour_whenItsNotPossible_returnNegative() {

        // Given
        int[] petrol = {1, 1, 1};
        int[] distance = {4, 6, 4};

        // When
        int result = Main.tour(petrol, distance);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}
