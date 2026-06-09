package code.wars.mean_vs_median;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.sort;

public class Solution {

    public static String meanVsMedian(int[] numbers) {

        sort(numbers);
        int sum = 0;
        List<Integer> numbersInTheMiddle = new ArrayList<>(2);
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length / 2) {
                numbersInTheMiddle.add(numbers[i]);
            }
            sum += numbers[i];
        }

        int mean = sum / numbers.length;
        int median = numbersInTheMiddle.stream().mapToInt(Integer::intValue).sum() / numbersInTheMiddle.size();

        if (mean > median) {
            return "mean";
        } else if (median > mean) {
            return "median";
        } else {
            return "same";
        }
    }
}
