package code.wars.atomic_chess;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.stream;

import java.util.Arrays;

public class AtomicChess {

    public static char[][] makeAtomicMove(final char[][] position, final String stringMove) {

        final var board = stream(position)
                .map(char[]::clone)
                .toArray(char[][]::new);

        final var move = Move.parse(stringMove);

        board[move.rowTo][move.columnTo] = board[move.rowFrom][move.columnFrom];
        board[move.rowFrom][move.columnFrom] = '.';

        if (move.takes()) {
            explosion(move.rowTo, move.columnTo, board);
        }

        return board;
    }

    private static void explosion(int rowTo, int columnTo, char[][] board) {
        for (int r = max(rowTo - 1, 0); r < min(rowTo + 2, board.length); r++) {
            for (int c = max(columnTo - 1, 0); c < min(columnTo + 2, board[0].length); c++) {
                if ((r != rowTo || c != columnTo) && (board[r][c] == 'P' || board[r][c] == 'p')) continue;
                board[r][c] = '.';
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