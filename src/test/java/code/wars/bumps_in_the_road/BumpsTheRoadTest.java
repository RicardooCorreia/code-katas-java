package code.wars.bumps_in_the_road;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BumpsTheRoadTest {

    @Test
    void bumps_whenLessThan15Bumps_returnWoohoo() {

        // Given
        final String input = "______n___n_";

        // When
        final String result = BumpsTheRoad.bumps(input);

        // Then
        assertThat(result)
                .isEqualTo("Woohoo!");
    }

    @Test
    void bumps_whenMoreThan15Bumps_returnCarDead() {

        // Given
        final String input = "_nnnnnnn_n__n______nn__nn_nnn";

        // When
        final String result = BumpsTheRoad.bumps(input);

        // Then
        assertThat(result)
                .isEqualTo("Car Dead");
    }

    @Test
    void bumps_when15Bumps_returnWoohoo() {

        // Given
        final String input = "_nnnnnnn_n__n______nn__nn_nn";

        // When
        final String result = BumpsTheRoad.bumps(input);

        // Then
        assertThat(result)
                .isEqualTo("Woohoo!");
    }
}
