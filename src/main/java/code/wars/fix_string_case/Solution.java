package code.wars.fix_string_case;

public class Solution {

    public static String solve(final String str) {

        int lowerCaseCount = 0, upperCaseCount = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else {
                upperCaseCount++;
            }
        }

        return lowerCaseCount >= upperCaseCount ? str.toLowerCase() : str.toUpperCase();
    }
}
