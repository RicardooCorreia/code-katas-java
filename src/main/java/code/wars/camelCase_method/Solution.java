package code.wars.camelCase_method;

public class Solution {

    public static final String EMPTY = "";

    public static final String SPACES_REGEX = "\\s+";

    public static String camelCase(String str) {

        if (str == null || str.isBlank()) {
            return EMPTY;
        }

        final String[] parts = str.trim().split(SPACES_REGEX);
        final StringBuilder stringBuilder = new StringBuilder();

        for (String part : parts) {
            final String firstLetter = part.substring(0, 1);
            final String restOfString = part.substring(1);
            stringBuilder
                    .append(firstLetter.toUpperCase())
                    .append(restOfString);
        }

        return stringBuilder.toString();
    }
}
