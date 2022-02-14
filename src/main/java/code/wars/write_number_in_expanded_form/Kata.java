package code.wars.write_number_in_expanded_form;

import java.util.ArrayList;
import java.util.List;

public class Kata {
    public static String expandedForm(int num) {

        final String s = String.valueOf(num);
        final List<String> numbers = new ArrayList<>();
        final char[] chars = s.toCharArray();
        final int length = chars.length;
        for (int i = 0; i < length; i++) {

            final int number = chars[i] - 48;
            if (number == 0) {
                continue;
            }
            numbers.add(numberWithCorrectZeros(length, i, number));
        }
        return String.join(" + ", numbers);
    }

    private static String numberWithCorrectZeros(int length, int i, int number) {

        final String format = "%-" + (length - i) + "s";
        return String.format(format, number)
                .replace(' ', '0');
    }
}
