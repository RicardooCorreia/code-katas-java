package code.wars.rock_paper_scissors_lizard_spock;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Kata {

    private static final Map<String, List<String>> BEATS = Map.of(
            "scissors", List.of("paper", "lizard"),
            "paper", List.of("rock", "spock"),
            "rock", List.of("lizard", "scissors"),
            "lizard", List.of("spock", "paper"),
            "spock", List.of("scissors", "rock")
    );

    public static String rpsls(String player1, String player2) {

        final String player1LowerCase = player1.toLowerCase(Locale.ROOT);
        final String player2LowerCase = player2.toLowerCase(Locale.ROOT);
        if (player1LowerCase.equals(player2LowerCase)) {
            return "Draw!";
        } else if (BEATS.get(player1LowerCase).contains(player2LowerCase)) {
            return "Player 1 Won!";
        } else {
            return "Player 2 Won!";
        }
    }
}
