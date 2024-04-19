package code.wars.twisted_3_7;

import java.util.Arrays;
import java.util.Comparator;

public class Kata {

    public static Integer[] sortTwisted37(Integer[] array) {

        return Arrays.stream(array)
                .sorted(Comparator.comparingInt(Kata::getTwistedVersion))
                .toArray(Integer[]::new);
    }

    private static Integer getTwistedVersion(Integer integer) {

        final String numberString = integer.toString();
        return Integer.valueOf(numberString
                .replaceAll("3", "s")
                .replaceAll("7", "t")
                .replaceAll("s", "7")
                .replaceAll("t", "3"));
    }
}
