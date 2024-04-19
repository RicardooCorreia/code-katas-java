package code.wars.connect_four;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ConnectFour {

    public static String whoIsWinner(List<String> piecesPositionList) {

        final Board<String> board = new Board<>();

        for (String play : piecesPositionList) {
            final String[] information = play.split("_");
            final int column = information[0].charAt(0) - 65;
            final String player = information[1];
            final Optional<String> winner = board.placePiece(column, player);

            if (winner.isPresent()) {

                return winner.get();
            }
        }

        return "Draw";
    }

    private static class Board<T> {

        public static final int SIZE = 7;

        private final List<Column<T>> columns = Stream.generate(() -> new Column<T>()).limit(SIZE).toList();

        private final WinnerChecker<T> winnerChecker = new WinnerChecker<>(this);

        public Optional<T> placePiece(int columnIndex, T piece) {

            final Column<T> column = columns.get(columnIndex);
            final int placedRow = column.placePiece(piece);

            return winnerChecker.checkWinner(piece, columnIndex, placedRow, column);
        }

        public List<Column<T>> getColumns() {
            return columns;
        }

        private static class Column<T> {

            private final List<T> places = new LinkedList<>();

            public int placePiece(T piece) {

                places.add(piece);
                return places.size() - 1;
            }

            public Optional<T> getPiece(int i) {

                if (i >= places.size()) {
                    return Optional.empty();
                }

                return Optional.ofNullable(places.get(i));
            }

            public List<T> getPlaces() {
                return places;
            }
        }
    }

    private record WinnerChecker<T>(Board<T> board) {

        public Optional<T> checkWinner(T piece,
                                       int placedColumnIndex,
                                       int placedRowIndex,
                                       Board.Column<T> placedColumn) {

            return checkVertically(piece, placedColumn, placedRowIndex)
                    .or(() -> checkHorizontally(piece, placedColumnIndex, placedRowIndex))
                    .or(() -> checkCrossRight(piece, placedColumnIndex, placedRowIndex))
                    .or(() -> checkCrossLeft(piece, placedColumnIndex, placedRowIndex));
        }

        private Optional<T> checkVertically(T piece, Board.Column<T> column, int placed) {
            if (placed < 3) {
                return Optional.empty();
            }
            return checkColumn(piece, column, placed);
        }

        private Optional<T> checkColumn(T piece, Board.Column<T> column, int placed) {
            for (int i = placed - 1, consecutive = 0; i >= 0; i--, consecutive++) {
                if (equalsPieceInPlace(piece, i, column)) {
                    if (consecutive == 2) {
                        return Optional.of(piece);
                    }
                } else {
                    break;
                }
            }
            return Optional.empty();
        }

        private Optional<T> checkHorizontally(T piece, int columnIndex, int placed) {

            final List<Board.Column<T>> columns = board.getColumns();

            int rightSideCount = 0, leftSideCount = 0;
            for (int i = columnIndex + 1; i < columns.size(); i++, rightSideCount++) {
                if (!equalsPieceInPlace(piece, placed, columns, i)) {
                    break;
                }
            }

            for (int i = columnIndex - 1; i >= 0; i--, leftSideCount++) {
                if (!equalsPieceInPlace(piece, placed, columns, i)) {
                    break;
                }
            }

            return checkWinner(rightSideCount, leftSideCount, piece);
        }

        private Optional<T> checkCrossRight(T piece, int columnIndex, int placed) {

            final List<Board.Column<T>> columns = board.getColumns();

            int rightSideCount = 0, leftSideCount = 0;
            for (int i = columnIndex + 1, rightRowIndex = placed + 1;
                 i < columns.size() && rightRowIndex < Board.SIZE;
                 i++, rightRowIndex++, rightSideCount++) {

                if (!equalsPieceInPlace(piece, rightRowIndex, columns, i)) {
                    break;
                }
            }

            for (int i = columnIndex - 1, leftRowIndex = placed - 1;
                 i >= 0 && leftRowIndex >= 0;
                 i--, leftRowIndex--, leftSideCount++) {

                if (!equalsPieceInPlace(piece, leftRowIndex, columns, i)) {
                    break;
                }
            }

            return checkWinner(rightSideCount, leftSideCount, piece);
        }

        private Optional<T> checkCrossLeft(T piece, int columnIndex, int placed) {

            final List<Board.Column<T>> columns = board.getColumns();

            int rightSide = 0, leftSide = 0;
            for (int i = columnIndex + 1, rightRowIndex = placed - 1;
                 i < Board.SIZE && rightRowIndex >= 0;
                 i++, rightSide++, rightRowIndex--) {

                if (!equalsPieceInPlace(piece, rightRowIndex, columns, i)) {
                    break;
                }
            }

            for (int i = columnIndex - 1, leftRowIndex = placed + 1;
                 i >= 0 && leftRowIndex < Board.SIZE;
                 i--, leftSide++, leftRowIndex++) {

                if (!equalsPieceInPlace(piece, leftRowIndex, columns, i)) {
                    break;
                }
            }

            return checkWinner(rightSide, leftSide, piece);
        }

        private Optional<T> checkWinner(int rightSide, int leftSide, T piece) {

            if (rightSide + leftSide >= 3) {
                return Optional.of(piece);
            } else {
                return Optional.empty();
            }
        }

        private Boolean equalsPieceInPlace(T piece, int rowIndex, List<Board.Column<T>> columns, int columnIndex) {

            return equalsPieceInPlace(piece, rowIndex, columns.get(columnIndex));
        }

        private Boolean equalsPieceInPlace(T piece, int rowIndex, Board.Column<T> column) {

            return column
                    .getPiece(rowIndex)
                    .map(piece::equals)
                    .orElse(false);
        }
    }
}
