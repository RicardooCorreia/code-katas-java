package code.wars.from_a_to_z;

public class Solution {
    public static String gimmeTheLetters(String s){

        final var parts = s.split("-");
        final var startChar = parts[0].charAt(0);
        final var endChar = parts[1].charAt(0);

        if (startChar == endChar) {
            return String.valueOf(startChar);
        }

        StringBuilder sb = new StringBuilder();
        char currentChar = startChar;
        do {
            sb.append(currentChar);
            currentChar++;
        } while (currentChar != endChar);
        sb.append(endChar);
        return sb.toString();
    }
}
