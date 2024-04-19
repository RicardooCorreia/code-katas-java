package code.wars.valid_parentheses_2;

import java.util.Objects;

public class Kata {

    public static boolean validParentheses(String parenStr) {

        if (parenStr == null || parenStr.isBlank()) {
            return true;
        }

        int openedParentheses = 0;
        for (String character : parenStr.split("")) {
            if (Objects.equals(character, "(")) {
                openedParentheses++;
            } else if (character.equals(")") && openedParentheses > 0) {
                openedParentheses--;
            } else {
                return false;
            }
        }
        return openedParentheses == 0;
    }
}
