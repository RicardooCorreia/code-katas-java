package other;

public class Parentheses {

    /**
     * Given a string representing a mathematical expression
     * return true if its parentheses are well balanced
     * E.g:
     * - "(1+3)*2" => true
     * - "((1+3)/2)*2" => true
     * - ")(1+3)" => false
     * - "(())" => true
     **/
    public boolean isBalanced(String exp) {

        int openParentheses = 0;
        for (String character : exp.split("")) {
            if (")".equals(character)) {
                if (openParentheses == 0) {
                    return false;
                } else {
                    openParentheses--;
                }
            } else if ("(".equals(character)) {
                openParentheses++;
            }
        }
        return openParentheses == 0;
    }
}
