package code.wars.bit_counting;

public class BitCounting {

    public static int countBits(int n) {

        return (int) Integer.toBinaryString(n).chars()
                .mapToObj(c -> c - 48)
                .filter(c -> c == 1)
                .count();
    }
}
