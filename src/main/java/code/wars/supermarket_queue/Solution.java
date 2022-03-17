package code.wars.supermarket_queue;

import java.util.Arrays;

public class Solution {

    public static final int EMPTY_CASHIER = -1;

    public static int solveSuperMarketQueue(int[] customers, int n) {

        if (n == 1) {
            return sum(customers);
        }

        if (customers.length == 0) {
            return 0;
        }

        if (n >= customers.length) {
            return Arrays.stream(customers).max().getAsInt();
        }

        return processCustomers(customers, n);
    }

    private static int processCustomers(int[] customers, int n) {

        int[] onCashiers = Arrays.copyOfRange(customers, 0, n);
        int[] onQueue = Arrays.copyOfRange(customers, n, customers.length);
        int timeToProcess = 0;

        while (onCashiers.length > 0) {
            int min = findMinimumCustomerTime(onCashiers);
            onQueue = processNewQueue(onCashiers, onQueue, min);
            onCashiers = removeEmptySpaces(onCashiers);
            timeToProcess+=min;
        }
        return timeToProcess;
    }

    private static int[] removeEmptySpaces(int[] onCashiers) {
        return Arrays.stream(onCashiers).filter(value -> value != EMPTY_CASHIER).toArray();
    }

    private static int[] processNewQueue(int[] onCashiers, int[] onQueue, int min) {

        for (int i = 0; i < onCashiers.length; i++) {
            // Reduce time to all cashiers
            onCashiers[i] -= min;
            onQueue = removeIfFinished(onCashiers, onQueue, i);
        }
        return onQueue;
    }

    private static int[] removeIfFinished(int[] onCashiers, int[] onQueue, int i) {

        if (onCashiers[i] == 0) {
            onQueue = processNewPosition(onCashiers, onQueue, i);
        }
        return onQueue;
    }

    private static int[] processNewPosition(int[] onCashiers, int[] onQueue, int i) {
        if (onQueue.length != 0) {
            onQueue = getNextPersonAndMoveQueueForward(onCashiers, onQueue, i);
        } else {
            onCashiers[i] = EMPTY_CASHIER;
        }
        return onQueue;
    }

    private static int[] getNextPersonAndMoveQueueForward(int[] onCashiers, int[] onQueue, int i) {
        onCashiers[i] = onQueue[0];
        onQueue = Arrays.copyOfRange(onQueue, 1, onQueue.length);
        return onQueue;
    }

    private static int findMinimumCustomerTime(int[] onCashiers) {
        int min = Integer.MAX_VALUE;
        for (int customer : onCashiers) {
            if (customer < min) {
                min = customer;
            }
        }
        return min;
    }

    private static int sum(int[] customers) {
        int sum = 0;
        for (int customer : customers) {
            sum += customer;
        }

        return sum;
    }
}
