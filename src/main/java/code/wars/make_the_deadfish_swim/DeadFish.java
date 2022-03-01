package code.wars.make_the_deadfish_swim;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DeadFish {

    public static int[] parse(String data) {

        final List<Integer> output = new LinkedList<>();
        final Map<Character, Function<Integer, Integer>> operations = Map.of(
                'i', integer -> ++integer,
                'd', integer -> --integer,
                's', integer -> integer * integer,
                'o', integer -> {
                    output.add(integer);
                    return integer;
                }
        );


        Integer initialValue = 0;

        data.chars()
                .mapToObj(codePoint -> (char) codePoint)
                .filter(operations::containsKey)
                .reduce(initialValue,
                        (integer, character) -> operations.get(character).apply(integer),
                        (integer, integer2) -> integer);

        return output.stream()
                .mapToInt(value -> value)
                .toArray();
    }
}
