package code.wars.translating_a_path;

import java.util.Map;

public class Solution {

    private static final Map<Character, String> TRANSLATION = Map.of(
        '^', "up",
        'v', "down",
        '<', "left",
        '>', "right"
    );

    public static String walk(String path) {

        if (path.isBlank()) {
            return "Paused";
        }

        char lastChar = ' ';
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char instruction : path.toCharArray()) {

            if (lastChar == ' ') {
                lastChar = instruction;
                count = 1;
            } else if (lastChar == instruction) {
                count++;
            } else {
                addInstruction(lastChar, count, stringBuilder);
                lastChar = instruction;
                count = 1;
            }
        }

        addInstruction(lastChar, count, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private static void addInstruction(char lastChar, int count, StringBuilder stringBuilder) {

        String instruction = TRANSLATION.get(lastChar);
        stringBuilder
                .append("Take ")
                .append(count)
                .append(" step");

        if (count > 1)
            stringBuilder.append("s");

        stringBuilder
                .append(" ")
                .append(instruction)
                .append("\n");
    }
}
