package code.wars.if_you_can_read_this;

import static java.lang.Character.isLetter;

public class Kata {

    public static String toNATO(String string) {

        if (string.isBlank()) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (var c : string.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (isLetter(c)) {
                final var natoWord = Helper.NATO.get(Character.toUpperCase(c));
                stringBuilder.append(natoWord);
            } else {
                stringBuilder.append(c);
            }
            stringBuilder.append(' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
