package code.wars.counting_sheep;

import java.util.Arrays;
import java.util.Objects;

public class Counter {
    public int countSheeps(Boolean[] arrayOfSheeps) {

        return (int) Arrays.stream(arrayOfSheeps)
                .filter(Objects::nonNull)
                .filter(aBoolean -> aBoolean)
                .count();
    }
}
