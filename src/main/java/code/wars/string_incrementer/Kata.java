package code.wars.string_incrementer;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {
    public static String incrementString(String str) {

        if (str == null) {
            return null;
        }

        final Pattern pattern = Pattern.compile("([0-9]+)$");
        final Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            return incrementTrailingNumber(str, matcher);
        } else {
            return str + "1";
        }
    }

    private static String incrementTrailingNumber(String str, Matcher matcher) {
        final String numbersString = matcher.group(1);
        final BigInteger incremented = new BigInteger(numbersString).add(BigInteger.ONE);
        final String incrementedFormatted = String.format("%0" + numbersString.length() + "d", incremented);
        return str.substring(0, matcher.start()) + incrementedFormatted;
    }
}
