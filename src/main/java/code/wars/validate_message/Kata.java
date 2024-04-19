package code.wars.validate_message;

import java.util.regex.Pattern;

public class Kata {

    public static boolean isAValidMessage(String message) {

        final Pattern pattern = Pattern.compile("(\\d+)(\\D*)");
        return pattern.matcher(message)
                .replaceAll(g -> Integer.parseInt(g.group(1)) == g.group(2).length() ? "" : "1")
                .isEmpty();
    }
}
