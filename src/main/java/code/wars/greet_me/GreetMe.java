package code.wars.greet_me;

import java.util.Locale;

public class GreetMe {
    public static String greet(String name) {

        final String trimmed = name.trim().toLowerCase(Locale.ROOT);
        return "Hello " + Character.toUpperCase(trimmed.charAt(0)) + trimmed.substring(1) + "!";
    }
}
