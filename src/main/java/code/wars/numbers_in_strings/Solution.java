package code.wars.numbers_in_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public static int solve(String s) {

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(s);
        int biggest = Integer.MIN_VALUE;
        while(matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            if(number > biggest) biggest = number;
        }

        return biggest;
    }
}
