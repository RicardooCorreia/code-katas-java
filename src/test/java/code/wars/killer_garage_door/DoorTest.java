package code.wars.killer_garage_door;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoorTest {

    @Test
    void run_whenNoButtonIsPressed_stayClosed() {

        // Given
        String input = "..........";

        // When
        String result = Door.run(input);

        // Then
        assertThat(result)
                .isEqualTo("0000000000");
    }

    @Test
    void run_whenButtonIsPressed_shouldOpen() {

        // Given
        String input = "P..";

        // When
        String result = Door.run(input);

        // Then
        assertThat(result)
                .isEqualTo("123");
    }

    @Test
    void run_whenButtonIsPressedAndWaitForEnd_shouldOpenAllTheWay() {

        // Given
        String input = "P....";

        // When
        String result = Door.run(input);

        // Then
        assertThat(result)
                .isEqualTo("12345");
    }

    @Test
    void run_whenButtonIsPressedTwice_shouldStartsAndStop() {

        // Given
        String input = "P.P..";

        // When
        String result = Door.run(input);

        // Then
        assertThat(result)
                .isEqualTo("12222");
    }

    @Test
    void run_whenButtonIsPressedAndFindsAnObstacle_shouldStartsAndGoBack() {

        // Given
        String input = "P.O....";

        // When
        String result = Door.run(input);

        // Then
        assertThat(result)
                .isEqualTo("1210000");
    }

    @Test
    void run_whenButtonIsPressedAndFindsAnObstacleAtTheEnd_shouldStartsAndGoBack() {

        // Given
        String input = "..P...O.....";

        // When
        String result = Door.run(input);

        // Then
        assertThat(result)
                .isEqualTo("001234321000");
    }
}
