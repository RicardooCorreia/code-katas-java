package code.wars.is_n_divisible;

public class Divisible {

    public static boolean isDivisible(int... numbers) {

        int dividend = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (dividend % numbers[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

