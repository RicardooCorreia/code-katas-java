package code.wars.supermarket_queue;

import java.util.Arrays;

public class Solution2 {

    public static int solveSuperMarketQueue(int[] customers, int n) {

        int[] result = new int[n];
        for (int customer : customers) {
            result[0] += customer;
            Arrays.sort(result);
        }
        return result[n - 1];
    }
}
