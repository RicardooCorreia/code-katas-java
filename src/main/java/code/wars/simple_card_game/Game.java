package code.wars.simple_card_game;

import java.util.List;

public class Game {

    private static final List<String> CARDS = List.of("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");

    public String winner(String[] deckSteve, String[] deckJosh) {

        int stevePoints = 0, joshPoints = 0;

        for (int i = 0; i < deckJosh.length; i++) {

            int steveCardValue = getCardValue(deckSteve[i]);
            int joshCardValue = getCardValue(deckJosh[i]);

            if (steveCardValue > joshCardValue) {
                stevePoints++;
            } else if (joshCardValue > steveCardValue) {
                joshPoints++;
            }
        }

        return returnWinner(stevePoints, joshPoints);
    }

    private String returnWinner(int stevePoints, int joshPoints) {

        if (stevePoints > joshPoints) {
            return String.format("Steve wins %s to %s", stevePoints, joshPoints);
        } else if (joshPoints > stevePoints) {
            return String.format("Josh wins %s to %s", joshPoints, stevePoints);
        } else {
            return "Tie";
        }
    }

    private int getCardValue(String deckSteve) {
        return CARDS.indexOf(deckSteve);
    }
}
