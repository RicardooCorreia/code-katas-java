package code.wars.remove_the_parentheses;

import java.util.Objects;

public class Kata {

    public static String removeParentheses(final String str) {

        StringBuilder stringBuilder = new StringBuilder();
        int parenthesesOpen = 0;
        for (String letter : str.split("")) {
            if (parenthesesOpen > 0 && Objects.equals(letter, ")")){
                parenthesesOpen--;
            } else if (Objects.equals(letter, "(")){
                parenthesesOpen++;
            } else if (parenthesesOpen == 0) {
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }
}
