package code.wars.playing_with_digits;

public class DigPow {

    public static long digPow(int n, int p) {

        final int[] numbers = String.valueOf(n)
                .chars()
                .map(operand -> operand - 48)
                .toArray();

        int powValue = p;
        double sum = 0;
        for (int number : numbers) {
            sum += Math.pow(number, powValue);
            powValue++;
        }

        final double result = sum / n;
        if (result > 0 && result % 1 == 0) {
            return (long) result;
        } else {
            return -1;
        }
    }
}
