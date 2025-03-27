package leetcode;

import java.util.Arrays;

/*
There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves,
 judge if this robot ends up at (0, 0) after it completes its moves.
You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move.
 Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once,
 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

Example 1:
    Input: moves = "UD"
    Output: true
    Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
Example 2:
    Input: moves = "LL"
    Output: false
    Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.

Constraints:
    1 <= moves.length <= 2 * 104
    moves only contains the characters 'U', 'D', 'L' and 'R'.
 */
public class RobotReturnToOrigin {

    static class Solution {
        public boolean judgeCircle(String moves) {

            return moves.chars()
                    .mapToObj(Move::valueOf)
                    .reduce(new Position(0, 0), Position::move,
                            (position, position2) -> new Position(position.x() + position2.x(), position.y() + position2.y()))
                    .isOrigin();
        }

        public record Position(int x, int y) {

            public Position move(Move move) {
                return switch (move) {
                    case L -> new Position(x() - 1, y());
                    case R -> new Position(x() + 1, y());
                    case U -> new Position(x(), y() + 1);
                    case D -> new Position(x(), y() - 1);
                };
            }

            public boolean isOrigin() {
                return x() == 0 && y() == 0;
            }
        }

        public enum Move {
            L, R, U, D;

            public static Move valueOf(int c) {
                return switch (c) {
                    case 'U' -> Move.U;
                    case 'D' -> Move.D;
                    case 'L' -> Move.L;
                    case 'R' -> Move.R;
                    default -> throw new RuntimeException("Not a move");
                };
            }
        }
    }

    static class Solution2 {
        public boolean judgeCircle(String moves) {

            int x = 0, y = 0;
            for (char c : moves.toCharArray()) {
                switch (c) {
                    case 'U':
                        y++;
                        break;
                    case 'D':
                        y--;
                        break;
                    case 'L':
                        x++;
                        break;
                    case 'R':
                        x--;
                        break;
                }
            }
            return x == 0 && y == 0;
        }
    }
}
