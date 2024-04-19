package code.wars.shorter_path;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestPathTest {

    @Test
    void directions_whenNoDeductions_stillSort() {

        // Given
        String[] input = {"N","N","N","N","N","E","N","N"};

        // When
        String[] result = ShortestPath.directions(input);

        // Then
        assertThat(result).isEqualTo(new String[]{"N", "N", "N", "N", "N", "N", "N", "E"});
    }

    @Test
    void directions_whenHasDeductions_returnCorrect() {

        // Given
        String[] input = {"S","S","N","E","W","S","N"};

        // When
        String[] result = ShortestPath.directions(input);

        // Then
        assertThat(result).isEqualTo(new String[]{"S"});
    }

    @Test
    void directions_whenDeductsAll_returnEmpty() {

        // Given
        String[] input = {"N","W","S","E"};

        // When
        String[] result = ShortestPath.directions(input);

        // Then
        assertThat(result).isEqualTo(new String[]{""});
    }
}
