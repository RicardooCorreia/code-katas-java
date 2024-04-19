package code.wars.interval;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Math {

    public static int[] Interval(int[] arr, String str) {

        final String regex = "^(.)(.+),(.+)(.)$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            boolean isStartOpen = matcher.group(1).equals("(");
            boolean isEndOpen = matcher.group(4).equals(")");

            int startNumber = Integer.parseInt(matcher.group(2));
            int endNumber = Integer.parseInt(matcher.group(3));

            return Arrays.stream(arr)
                    .filter(value -> isStartOpen ? value > startNumber : value >= startNumber)
                    .filter(value -> isEndOpen ? value < endNumber : value <= endNumber)
                    .sorted()
                    .toArray();
        }
        return new int[0];
    }
}
