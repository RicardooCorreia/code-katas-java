package code.wars.find_min_and_max;

import java.util.Arrays;

public class Kata {

    public int min(int[] list) {
        return Arrays.stream(list)
                .min()
                .orElseThrow();
    }

    public int max(int[] list) {
        return Arrays.stream(list)
                .max()
                .orElseThrow();
    }
}
