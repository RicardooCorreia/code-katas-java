package code.wars.double_trouble;

import java.util.ArrayList;

public class Solution {

    public static int[] trouble(int[] x, int t) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(x[0]);
        for (int i = 1; i < x.length; i++) {
            if (x[i] + result.getLast() == t) {
                continue;
            }
            result.add(x[i]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
