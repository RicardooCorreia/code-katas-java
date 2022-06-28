package code.wars.rock_paper_scissors;

import java.util.Map;

public class Kata {

    private final static Map<String, String> BEATS = Map.of(
            "rock", "scissors",
            "scissors", "paper",
            "paper", "rock");

    public static String rps(String p1, String p2) {

        if (p1.equals(p2)) {
            return "Draw!";
        } else if (beats(p1, p2)) {
            return "Player 1 won!";
        } else {
            return "Player 2 won!";
        }
    }

    private static boolean beats(String p1, String p2) {
        return BEATS.get(p1).equals(p2);
    }
}
