package code.wars.rook_count_attack;

import java.util.HashSet;
import java.util.Set;

public class RookUtils {

    public static int countAttackingRooks(int[][] rooks) {

        Set<Integer> coveredColumns = new HashSet<>();
        Set<Integer> coveredRows = new HashSet<>();
        int attacks = 0;
        for (var rook : rooks) {
            final var column = rook[0];
            final var row = rook[1];

            if (!coveredColumns.add(column)) {
                attacks++;
            }
            if (!coveredRows.add(row)) {
                attacks++;
            }
        }
        return attacks;
    }
}
