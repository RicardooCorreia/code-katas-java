package code.wars.tribonacci_sequence;

import java.util.Arrays;

public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {

        double[] numbers = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
        }
        return numbers;
    }
}
