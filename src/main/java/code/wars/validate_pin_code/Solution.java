package code.wars.validate_pin_code;

import java.util.regex.Pattern;

public class Solution {

    public static final Pattern PATTERN = Pattern.compile("^(\\d{4}|\\d{6})$");

    public static boolean validatePin(String pin) {

        if (pin.length() != 4 && pin.length() != 6) return false;
        return PATTERN.matcher(pin).find();
    }

}
