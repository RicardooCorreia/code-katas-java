package code.wars.collatz_conjecture_length;

public class Collatz {

    public static long conjecture(long x) {

        long currentNumber = x;
        int count = 1;

        while (currentNumber != 1) {
            currentNumber = calculateNextNumber(currentNumber);
            count++;
        }
        return count;
    }

    private static long calculateNextNumber(long currentNumber) {
        final boolean isPair = currentNumber % 2 == 0;
        if (isPair) {
            return currentNumber / 2;
        } else {
            return currentNumber * 3 + 1;
        }
    }
}
