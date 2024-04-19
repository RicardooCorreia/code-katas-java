package code.wars.credit_card_mask;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Maskify {

    private static final Pattern PATTERN = Pattern.compile("^(.+)(.{4})$");

    public static String maskify(String string) {

        final Matcher matcher = PATTERN.matcher(string);
        if (!matcher.find()) {
            return string;
        }
        final String toMask = matcher.group(1);
        final String shown = matcher.group(2);
        final String masked = maskNumbers(toMask);
        return masked + shown;
    }

    private static String maskNumbers(String toMask) {
        final char[] chars = new char[toMask.length()];
        Arrays.fill(chars, '#');
        return new String(chars);
    }
}

