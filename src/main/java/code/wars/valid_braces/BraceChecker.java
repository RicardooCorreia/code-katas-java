package code.wars.valid_braces;

import java.util.Map;
import java.util.Stack;

public class BraceChecker {

    private final Map<Character, Character> correspondingBraces = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public boolean isValid(String braces) {

        final Stack<Character> openBraces = new Stack<>();
        for (char brace : braces.toCharArray()) {
            if (brace == '(' || brace == '[' || brace == '{') {
                openBraces.push(brace);
            } else {
                if (openBraces.isEmpty()) return false;
                final Character lastOpen = openBraces.pop();
                final Character correspondingOpenBrace = correspondingBraces.get(brace);
                if (correspondingOpenBrace != null && lastOpen != correspondingOpenBrace) return false;
            }
        }
        return openBraces.isEmpty();
    }
}
