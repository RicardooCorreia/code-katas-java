package code.wars.uno_match_play;

public class Kata {

    public static boolean canPlay(String[] hand, String faceUp) {

        final Card faceUpCard = Card.of(faceUp);

        for (String string : hand) {
            final Card cardInHand = Card.of(string);
            if (cardInHand.color().equals(faceUpCard.color()) || cardInHand.number().equals(faceUpCard.number())) {
                return true;
            }
        }
        return false;
    }

    private record Card(String color, String number) {

        private static Card of(String input) {
            final String[] parts = input.split(" ");
            final String color = parts[0];
            final String number = parts[1];
            return new Card(color, number);
        }
    }
}
