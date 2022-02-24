package code.wars.valid_parentheses;

public class Solution {

    public static boolean validParentheses(String parens) {

        int openParentheses = 0;

        for (char character : parens.toCharArray()) {
            openParentheses = getOpenParentheses(openParentheses, character);

            if (openParentheses < 0) {
                return false;
            }
        }
        return openParentheses == 0;
    }

    private static int getOpenParentheses(int openParentheses, char character) {

        if (character == ')') {
            return openParentheses - 1;
        } else if (character == '(') {
            return openParentheses + 1;
        } else {
            return openParentheses;
        }
    }
}
