package code.wars.scramblies;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Scramblies {

    public static boolean scramble(String str1, String str2) {

        final Map<Integer, Long> supply = getLetterCount(str1);
        final Map<Integer, Long> demand = getLetterCount(str2);

        for (Map.Entry<Integer, Long> letterRequirement : demand.entrySet()) {
            final Integer letter = letterRequirement.getKey();
            final Long quantityRequired = letterRequirement.getValue();
            final Long quantityInSupply = supply.get(letter);

            if (quantityInSupply == null || quantityRequired > quantityInSupply) {
                return false;
            }
        }

        return true;
    }

    private static Map<Integer, Long> getLetterCount(String string) {

        return string.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}