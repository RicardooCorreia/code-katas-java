package code.wars.dashatize_it;

public class Solution {

    public static String dashatize(int num) {

        String fullNumber = String.valueOf(Math.abs(num));
        if (fullNumber.length() < 2) {
            return fullNumber;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : fullNumber.toCharArray()) {
            if (c == '-') {
                continue;
            }
            addNumberToResult(stringBuilder, c);
        }

        return stringBuilder.toString()
                .trim()
                .replaceAll(" {2}", " ")
                .replaceAll(" ", "-");
    }

    private static void addNumberToResult(StringBuilder stringBuilder, char c) {

        int number = c - 48;
        if (number % 2 != 0) {
            stringBuilder.append(" ");
            stringBuilder.append(number);
            stringBuilder.append(" ");
        } else {
            stringBuilder.append(number);
        }
    }
}
