package code.wars.calculate_mean_and_concatenate_string;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

public class Kata {

    public static Object[] mean(char[] chars) {

        int sum = 0, count = 0;
        StringBuilder string = new StringBuilder();
        for (char aChar : chars) {
            if (isAlphabetic(aChar)) {
                string.append(aChar);
            } else if (isDigit(aChar)) {
                sum += Character.getNumericValue(aChar);
                count++;
            }
        }

        return new Object[]{(double) sum / count, string.toString()};
    }
}
