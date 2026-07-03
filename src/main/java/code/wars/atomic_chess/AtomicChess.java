package code.wars.atomic_chess;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AtomicChess {

    public static char[][] makeAtomicMove(final char[][] position, final String stringMove) {

        final var move = Move.parse(stringMove);

        position[move.rowTo][move.columnTo] = position[move.rowFrom][move.columnFrom];
        position[move.rowFrom][move.columnFrom] = '.';

        if (move.takes()) {
            explosion(move.columnTo, move.rowTo, position);
        }

        return position;
    }

    private static void explosion(int columnTo, int rowTo, char[][] position) {

        position[rowTo][columnTo] = '.';
        for (int i = max(columnTo - 1, 0); i < min(columnTo + 2, position.length); i++) {
            for (int j = max(rowTo - 1, 0); j < min(rowTo + 2, position[0].length); j++) {
                if (position[j][i] == 'P' || position[j][i] == 'p') continue;
                position[j][i] = '.';
            }
        }
    }

    record Move(int columnFrom, int rowFrom, int columnTo, int rowTo, boolean takes) {

        private static Move parse(String string) {

            final var columnFrom = string.charAt(0) - 'a';
            final var rowFrom = 8 - (string.charAt(1) - '0');
            final var takes = string.charAt(2) == 'x';
            final var columnTo = string.charAt(3) - 'a';
            final var rowTo = 8 - (string.charAt(4) - '0');

            return new Move(columnFrom, rowFrom, columnTo, rowTo, takes);
        }
    }
}
