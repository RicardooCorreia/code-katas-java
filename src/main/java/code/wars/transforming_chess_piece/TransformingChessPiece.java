package code.wars.transforming_chess_piece;

import java.util.*;

public class TransformingChessPiece {
    public static List<Character> capturePieces(char[][] board, char piece) {

        Map<Character, ChessPiecePosition> boardPositions = new HashMap<>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] != '.') {
                    ChessPiece chessPiece = ChessPieces.get(board[x][y]);
                    boardPositions.put(board[x][y], new ChessPiecePosition(chessPiece, x, y));
                }
            }
        }

        Optional<ChessPiecePosition> next = Optional.ofNullable(boardPositions.get(piece));

        while (next.isPresent()) {
            ChessPiecePosition chessPiecePosition = next.get();
            Optional<ChessPiecePosition> captured = chessPiecePosition.chessPiece().captureNext(board, chessPiecePosition.x(), chessPiecePosition.y());
            if (captured.isPresent()) {
                boardPositions.remove(chessPiecePosition.chessPiece().getCharacter());
                board[chessPiecePosition.x()][chessPiecePosition.y()] = '.';
            }
            next = captured;
        }

        return boardPositions.keySet()
                .stream()
                .sorted()
                .toList();
    }

    private interface ChessPiece {

        Optional<ChessPiecePosition> captureNext(char[][] board, int x, int y);

        Character getCharacter();
    }

    private static final class ChessPieces {

        public static ChessPiece get(char piece) {
            return switch (piece) {
                case 'K' -> new King();
                case 'B' -> new Bishop();
                case 'R' -> new Rook();
                case 'Q' -> new Queen();
                case 'N' -> new Knight();
                case 'P' -> new Pawn();
                default -> throw new RuntimeException("Chess piece unrecognized");
            };
        }
    }

    private static class King implements ChessPiece {

        @Override
        public Optional<ChessPiecePosition> captureNext(char[][] board, int x, int y) {
            boolean hasSpaceTop = x > 0;
            boolean hasSpaceBottom = x < board.length - 1;
            boolean hasSpaceLeft = y > 0;
            boolean hasSpaceRight = y < board[0].length - 1;

            if (hasSpaceTop) {
                if (board[x - 1][y] != '.') {
                    return captureChessPosition(board, x - 1, y);
                }
                if (hasSpaceLeft && board[x - 1][y - 1] != '.') {
                    return captureChessPosition(board, x - 1, y - 1);
                }
                if (hasSpaceRight && board[x - 1][y + 1] != '.') {
                    return captureChessPosition(board, x - 1, y + 1);
                }
            }
            if (hasSpaceBottom) {
                if (board[x + 1][y] != '.') {
                    return captureChessPosition(board, x + 1, y);
                }
                if (hasSpaceLeft && board[x + 1][y - 1] != '.') {
                    return captureChessPosition(board, x + 1, y - 1);
                }
                if (hasSpaceRight && board[x + 1][y + 1] != '.') {
                    return captureChessPosition(board, x + 1, y + 1);
                }
            }
            if (hasSpaceLeft && board[x][y - 1] != '.') {
                return captureChessPosition(board, x, y - 1);
            }
            if (hasSpaceRight && board[x][y + 1] != '.') {
                return captureChessPosition(board, x, y + 1);
            }
            return Optional.empty();
        }

        @Override
        public Character getCharacter() {
            return 'K';
        }
    }

    private static class Queen implements ChessPiece {

        @Override
        public Optional<ChessPiecePosition> captureNext(char[][] board, int x, int y) {

            Optional<ChessPiecePosition> capture = checkHorizontalAndVertical(board, x, y);
            if (capture.isPresent()) return capture;
            capture = checkDiagonals(board, x, y);
            return capture;
        }

        @Override
        public Character getCharacter() {
            return 'Q';
        }
    }

    private static class Pawn implements ChessPiece {

        @Override
        public Optional<ChessPiecePosition> captureNext(char[][] board, int x, int y) {
            if (x > 0) {
                if (y > 0 && board[x - 1][y - 1] != '.') {
                    return captureChessPosition(board, x - 1, y - 1);
                }
                if (y < board[0].length - 1 && board[x - 1][y + 1] != '.') {
                    return captureChessPosition(board, x - 1, y + 1);
                }
            }
            return Optional.empty();
        }

        @Override
        public Character getCharacter() {
            return 'P';
        }
    }

    private static Optional<ChessPiecePosition> captureChessPosition(char[][] board, int x, int y) {
        return Optional.of(new ChessPiecePosition(ChessPieces.get(board[x][y]), x, y));
    }

    private static class Rook implements ChessPiece {

        @Override
        public Optional<ChessPiecePosition> captureNext(char[][] board, int x, int y) {
            return checkHorizontalAndVertical(board, x, y);
        }

        @Override
        public Character getCharacter() {
            return 'R';
        }
    }

    private static class Bishop implements ChessPiece {

        @Override
        public Optional<ChessPiecePosition> captureNext(char[][] board, int x, int y) {
            return checkDiagonals(board, x, y);
        }

        @Override
        public Character getCharacter() {
            return 'B';
        }
    }

    private static class Knight implements ChessPiece {

        @Override
        public Optional<ChessPiecePosition> captureNext(char[][] board, int x, int y) {
            int[][] moves = {
                    {x - 2, y - 1},
                    {x - 2, y + 1},
                    {x - 1, y - 2},
                    {x - 1, y + 2},
                    {x + 1, y - 2},
                    {x + 1, y + 2},
                    {x + 2, y + 1},
                    {x + 2, y - 1},
            };
            for (int[] move : moves) {
                int newX = move[0];
                int newY = move[1];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    if (board[newX][newY] != '.') {
                        return captureChessPosition(board, newX, newY);
                    }
                }
            }
            return Optional.empty();
        }

        @Override
        public Character getCharacter() {
            return 'N';
        }
    }

    private record ChessPiecePosition(ChessPiece chessPiece, int x, int y) {
    }

    private static Optional<ChessPiecePosition> checkHorizontalAndVertical(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] != '.' && i != y) {
                return captureChessPosition(board, x, i);
            }
            if (board[i][y] != '.' && i != x) {
                return captureChessPosition(board, i, y);
            }
        }
        return Optional.empty();
    }

    private static Optional<ChessPiecePosition> checkDiagonals(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (x + i < board.length && y + i < board[0].length && board[x + i][y + i] != '.' && i != 0) {
                return captureChessPosition(board, x + i, y + i);
            }
            if (x - i >= 0 && y - i >= 0 && board[x - i][y - i] != '.' && i != 0) {
                return captureChessPosition(board, x - i, y - i);
            }
            if (x + i < board.length && y - i >= 0 && board[x + i][y - i] != '.' && i != 0) {
                return captureChessPosition(board, x + i, y - i);
            }
            if (x - i >= 0 && y + i < board[0].length && board[x - i][y + i] != '.' && i != 0) {
                return captureChessPosition(board, x - i, y + i);
            }
        }
        return Optional.empty();
    }
}
