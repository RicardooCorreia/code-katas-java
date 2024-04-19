package code.wars.last_survivor;

import java.util.Arrays;

public class Kata {

    public static String lastSurvivor(String letters, int[] coords) {

        if (coords.length == 0) {
            return letters;
        }

        int index = coords[0];
        String firstPart = letters.substring(0, index);
        String secondPart = letters.substring(index + 1);
        return lastSurvivor(firstPart + secondPart, Arrays.copyOfRange(coords, 1, coords.length));
    }
}
