package other;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ProperlyNested {

    /**
     * An input string containing a mix of the following characters "([{}])".
     * You need to write a function that returns true if the string is properly nested.
     * Here are a few examples
     * isCorrectlyNested("([{}])") should return true
     * isCorrectlyNested("([{") should return false
     * isCorrectlyNested("([{))") should return false
     * isCorrectlyNested("([){}]") should return false
     * isCorrectlyNested("(){}[]") should return true
     * isCorrectlyNested("({}[])") should return true
     **/
    private static final Map<String, String> closingCounterParts = Map.of(
            "}", "{",
            ")", "(",
            "]", "["
    );

    public boolean isCorrectlyNested(String input) {

        Stack<String> stack = new Stack<>();
        for (String character : input.split("")) {
            if (closingCounterParts.containsValue(character)) {
                stack.push(character);
            } else {
                String opening = closingCounterParts.get(character);
                if (opening.equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
