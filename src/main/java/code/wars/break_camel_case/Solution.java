package code.wars.break_camel_case;

class Solution {

    public static String camelCase(String input) {

        // positive lookaround
        return String.join(" ", input.split("(?=[A-Z])"));
    }
}
