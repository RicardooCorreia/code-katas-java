package code.wars.convert_string_to_camel_case;

public class Solution {

    static String toCamelCase(String string) {


        final String[] parts = string.split("[-_]");

        final StringBuilder stringBuilder = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {

            final String part = parts[i];
            final String firstLetter = part.substring(0, 1);
            final String remaining = part.substring(1);

            stringBuilder
                    .append(firstLetter.toUpperCase())
                    .append(remaining);
        }
        return stringBuilder.toString();
    }
}
