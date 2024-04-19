package code.wars.evil_autocorrect_prank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {

    public static String autocorrect(String input) {

        String replaced = replaceRegex(input, "\\b([yY])([oO])([uU])+\\b");
        return replaceRegex(replaced, "\\b([uU])\\b");
    }

    private static String replaceRegex(String input, String regex) {

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.replaceAll("your sister");
        } else {
            return input;
        }
    }
}
