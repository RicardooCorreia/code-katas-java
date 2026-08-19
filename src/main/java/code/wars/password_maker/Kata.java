package code.wars.password_maker;

public class Kata {

    public static String makePassword(String phrase) {

        if (phrase.isBlank()) {
            return phrase;
        }

        final var words = phrase.split(" ");
        StringBuilder password = new StringBuilder();
        for (String word : words) {
            password.append(getToken(word));
        }
        return password.toString();
    }

    private static char getToken(String word) {

        final var firstLetter = word.charAt(0);
        return switch (Character.toLowerCase(firstLetter)) {
            case 'i' -> '1';
            case 'o' -> '0';
            case 's' -> '5';
            default -> firstLetter;
        };
    }
}
