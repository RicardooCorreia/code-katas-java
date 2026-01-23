package code.wars.findTheMine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MineFinderTest {

    @Test
    void findMine_whenMineAtTopLeft_returnCorrectPosition() {
        // Given
        int[][] field = {{1, 0}, {0, 0}};

        // When
        int[] result = MineFinder.findMine(field);

        // Then
        assertThat(result).containsExactly(0, 0);
    }

    @Test
    void findMine_whenMineAtTopLeftIn3x3Grid_returnCorrectPosition() {
        // Given
        int[][] field = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        // When
        int[] result = MineFinder.findMine(field);

        // Then
        assertThat(result).containsExactly(0, 0);
    }

    @Test
    void findMine_whenMineAtBottomRightIn4x4Grid_returnCorrectPosition() {
        // Given
        int[][] field = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};

        // When
        int[] result = MineFinder.findMine(field);

        // Then
        assertThat(result).containsExactly(2, 2);
    }
}
