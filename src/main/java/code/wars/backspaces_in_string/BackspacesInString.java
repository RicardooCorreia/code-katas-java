package code.wars.backspaces_in_string;

import java.util.Stack;

public class BackspacesInString {

    public static final char BACKSPACE = '#';

    public String cleanString(String s) {

        final Stack<String> characters = new Stack<>();
        for (char c : s.toCharArray()) {
            manageCharacters(characters, c);
        }
        return String.join("", characters);
    }

    private static void manageCharacters(Stack<String> characters, char c) {

        if (c != BACKSPACE) {
            characters.push(String.valueOf(c));
        } else if (!characters.isEmpty()) {
            characters.pop();
        }
    }
}
