package code.wars.replace_with_alphabet_position;

// https://www.codewars.com/kata/546f922b54af40e1e90001da/train/java
public class Kata {
    static String alphabetPosition(String text) {

        if (text == null || text.isBlank()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stringBuilder
                        .append(Character.toLowerCase(c) - 96)
                        .append(" ");
            }
        }
        if (!stringBuilder.isEmpty()) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }
}

