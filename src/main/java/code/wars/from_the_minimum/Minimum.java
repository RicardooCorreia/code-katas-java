package code.wars.from_the_minimum;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Minimum{

    public static int minValue(int[] values){

        return Integer.parseInt(Arrays.stream(values)
                .distinct()
                .sorted()
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }
}
