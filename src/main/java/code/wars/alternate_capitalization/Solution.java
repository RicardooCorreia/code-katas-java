package code.wars.alternate_capitalization;

import java.util.Locale;

class Solution {

    public static String[] capitalize(String s) {

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        boolean flag = true;
        for (char c : s.toLowerCase(Locale.ROOT).toCharArray()) {
            String letter = String.valueOf(c);
            String upperCase = letter.toUpperCase(Locale.ROOT);
            if (flag) {
                first.append(upperCase);
                second.append(letter);
            } else {
                first.append(letter);
                second.append(upperCase);
            }
            flag = !flag;
        }

        return new String[]{first.toString(), second.toString()};
    }
}
