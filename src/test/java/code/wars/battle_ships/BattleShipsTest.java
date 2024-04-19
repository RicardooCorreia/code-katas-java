package code.wars.battle_ships;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BattleShipsTest {

    @Test
    public void damagedOrSunk_when1Ship_returnCorrectValues() {

        // Given
        int[][] board = new int[][]{
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 1, 0}};
        int[][] attacks = new int[][]{new int[]{3, 1}, new int[]{3, 2}, new int[]{3, 3}};

        Map<String, Double> expected = new HashMap<>();
        expected.put("sunk", 1.0);
        expected.put("damaged", .0);
        expected.put("notTouched", .0);
        expected.put("points", 1.0);

        // When
        final Map<String, Double> result = BattleShips.damagedOrSunk(board, attacks);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void damagedOrSunk_when3Ships_returnCorrectValues() {

        // Given
        int[][] board = new int[][]{
                new int[]{3, 0, 1},
                new int[]{3, 0, 1},
                new int[]{0, 2, 1},
                new int[]{0, 2, 0}};
        int[][] attacks = new int[][]{new int[]{2, 1}, new int[]{2, 2}, new int[]{3, 2}, new int[]{3, 3}};

        Map<String, Double> expected = new HashMap<>();
        expected.put("sunk", 1.0);
        expected.put("damaged", 1.0);
        expected.put("notTouched", 1.0);
        expected.put("points", 0.5);

        // When
        final Map<String, Double> result = BattleShips.damagedOrSunk(board, attacks);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}