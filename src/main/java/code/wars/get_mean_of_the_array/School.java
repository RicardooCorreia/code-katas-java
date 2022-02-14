package code.wars.get_mean_of_the_array;

import java.util.Arrays;

public class School{

    public static int getAverage(int[] marks){

        return (int) Arrays.stream(marks)
                .average()
                .orElse(0.0);
    }
}