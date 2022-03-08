package code.wars.battle_ships;

import java.util.HashMap;
import java.util.Map;

public class BattleShips {

    public static Map<String, Double> damagedOrSunk(final int[][] board, final int[][] attacks) {

        final Map<Integer, Integer> shipsHealth = new HashMap<>();
        initShipHealth(board, shipsHealth);
        final Map<Integer, Integer> shipOriginalHealth = new HashMap<>(shipsHealth);
        computeAttacks(board, attacks, shipsHealth);
        return calculatePoints(shipsHealth, shipOriginalHealth);
    }

    private static void computeAttacks(int[][] board, int[][] attacks, Map<Integer, Integer> shipsHealth) {

        for (int[] attack : attacks) {
            final int x = board.length - attack[1];
            final int y = attack[0] - 1;
            final int square = board[x][y];
            shipsHealth.computeIfPresent(square, (integer, value) -> value - 1);
        }
    }

    private static Map<String, Double> calculatePoints(Map<Integer, Integer> shipsHealth,
                                                       Map<Integer, Integer> shipOriginalHealth) {

        double sunk = .0;
        double damaged = .0;
        double notTouched = .0;
        for (Map.Entry<Integer, Integer> entry : shipsHealth.entrySet()) {
            final Integer ship = entry.getKey();
            final Integer shipHealth = entry.getValue();
            if (shipHealth == 0) {
                sunk++;
            } else if (shipHealth.equals(shipOriginalHealth.get(ship))) {
                notTouched++;
            } else {
                damaged++;
            }
        }

        double points = sunk + (.5 * damaged) - notTouched;
        return Map.of(
                "sunk", sunk,
                "damaged", damaged,
                "notTouched", notTouched,
                "points", points);
    }

    private static void initShipHealth(int[][] board, Map<Integer, Integer> shipHealth) {
        for (int[] ints : board) {
            for (final int square : ints) {
                if (square != 0) {
                    shipHealth.merge(square, 1, Integer::sum);
                }
            }
        }
    }
}