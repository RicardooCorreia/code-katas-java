package code.wars.reverse_letter;

import static java.lang.Character.isAlphabetic;

public class Kata {
    public static String reverseLetter(final String str) {

        StringBuilder sb = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) {
            final var c = str.charAt(i);
            if(isAlphabetic(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
