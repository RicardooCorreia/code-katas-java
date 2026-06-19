package code.wars.lucky_number;

import static java.lang.Integer.parseInt;

public class LuckyNumber {

    public static boolean isLucky(long n) {

        long sum = 0;
        for (var string : String.valueOf(n).split("")) {
            final var number = parseInt(string);
            sum += number;
        }
        return sum % 9 == 0;
    }
}
