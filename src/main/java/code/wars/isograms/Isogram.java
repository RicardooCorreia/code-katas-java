package code.wars.isograms;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Isogram {

    public static boolean isIsogram(String str) {

        return str.chars()
                .mapToObj(Character::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .noneMatch(count -> count > 1);
    }
}
