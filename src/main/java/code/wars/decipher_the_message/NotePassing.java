package code.wars.decipher_the_message;

import static java.lang.Character.isLetter;
import static java.lang.Character.isLowerCase;

public class NotePassing {

    public static String decipher(String codedMessage) {

        StringBuilder result = new StringBuilder();
        for (char c : codedMessage.toCharArray()) {
            result.append(decipherLetter(c));
        }
        return result.toString();
    }

    public static char decipherLetter(char input) {
        if (!isLetter(input)) return input;
        char decoded = (char) ((input + 7));
        if (isLowerCase(input)) {
            if (decoded > 'z') {
                decoded = (char) (decoded - 'z' + 'a' - 1);
            }
        } else {
            if (decoded > 'Z') {
                decoded = (char) (decoded - 'Z' + 'A' - 1);
            }
        }
        return decoded;
    }
}
