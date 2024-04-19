package code.wars.tic_tac_toe_checker;

public class Solution {

    public static int isSolved(int[][] board) {

        boolean isThereEmptySpaces = false;
        BoardResult boardResult = new BoardResult(false, false);
        for (int x = 0; x < board.length; x++) {

            if (!isThereEmptySpaces) {
                for (int i = 0; i < board[x].length; i++) {
                    if (board[x][i] == 0) {
                        isThereEmptySpaces = true;
                        break;
                    }
                }
            }

            // Check horizontal
            if (isNotEmpty(board[x][0]) && board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
                boardResult = calculateBoardResult(boardResult, board[x][0]);
            }

            // Check vertical
            if (isNotEmpty(board[0][x]) && board[0][x] == board[1][x] && board[0][x] == board[2][x]) {
                boardResult = calculateBoardResult(boardResult, board[0][x]);
            }
        }

        // Check crosses
        int topLeft = board[0][0];
        int middle = board[1][1];
        int bottomRight = board[2][2];
        if (isNotEmpty(topLeft) && topLeft == middle && topLeft == bottomRight) {
            boardResult = calculateBoardResult(boardResult, topLeft);
        }

        int topRight = board[2][0];
        int bottomLeft = board[0][2];
        if (isNotEmpty(topRight) && topRight == middle && topRight == bottomLeft) {
            boardResult = calculateBoardResult(boardResult, topRight);
        }

        int result = boardResult.getResult();
        return result == 0 && isThereEmptySpaces ? -1 : result;
    }

    private static BoardResult calculateBoardResult(BoardResult boardResult, int winningNumber) {

        if (winningNumber == 1) {
            return new BoardResult(true, boardResult.twoWins());
        } else {
            return new BoardResult(boardResult.oneWins(), true);
        }
    }

    private static boolean isNotEmpty(int topRight) {

        return topRight != 0;
    }

    public record BoardResult(boolean oneWins, boolean twoWins) {

        public int getResult() {
            if (oneWins == twoWins) {
                return 0;
            } else if (oneWins) {
                return 1;
            } else {
                return 2;
            }
        }
    }
}
