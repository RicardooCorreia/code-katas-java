package code.wars.persistent_burger;

public class Persist {

    public static int persistence(long n) {

        if (n < 10) return 0;

        long numberToCalculate = n;
        int iteration = 0;
        do {
            numberToCalculate = String.valueOf(numberToCalculate)
                    .chars()
                    .map(operand -> operand - 48)
                    .reduce((left, right) -> left * right)
                    .orElseThrow(() -> new RuntimeException("No number to calculate"));
            iteration++;
        } while (numberToCalculate >= 10);
        return iteration;
    }
}
