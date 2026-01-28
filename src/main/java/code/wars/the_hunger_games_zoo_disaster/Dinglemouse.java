package code.wars.the_hunger_games_zoo_disaster;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/5902bc7aba39542b4a00003d/train/java
 */
public class Dinglemouse {

    private static final Map<String, Set<String>> FOOD_CHAIN = Map.ofEntries(
            Map.entry("antelope", Set.of("grass")),
            Map.entry("big-fish", Set.of("little-fish")),
            Map.entry("bug", Set.of("leaves")),
            Map.entry("bear", Set.of("big-fish", "bug", "chicken", "cow", "leaves", "sheep")),
            Map.entry("chicken", Set.of("bug")),
            Map.entry("cow", Set.of("grass")),
            Map.entry("fox", Set.of("chicken", "sheep")),
            Map.entry("giraffe", Set.of("leaves")),
            Map.entry("lion", Set.of("antelope", "cow")),
            Map.entry("panda", Set.of("leaves")),
            Map.entry("sheep", Set.of("grass"))
    );

    public static String[] whoEatsWho(final String zoo) {

        List<String> animals = new ArrayList<>(Arrays.asList(zoo.split(",")));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            String animal = animals.get(i);
            Set<String> food = FOOD_CHAIN.get(animal);

            if (food == null || food.isEmpty()) {
                continue;
            }

            int leftPosition = i - 1;
            if (i > 0) {
                String leftAnimal = animals.get(leftPosition);
                if (food.contains(leftAnimal)) {
                    animals.remove(i - 1);
                    result.add(animal + " eats " + leftAnimal);
                    i = Math.max(i - 3, -1);
                    continue;
                }
            }

            int rightPosition = i + 1;
            if (i < animals.size() - 1) {
                String rightAnimal = animals.get(rightPosition);
                if (food.contains(rightAnimal)) {
                    animals.remove(i + 1);
                    result.add(animal + " eats " + rightAnimal);
                    i--;
                }
            }
        }

        result.addFirst(zoo);
        result.add(animals.stream().collect(Collectors.joining(",")));
        return result.toArray(new String[0]);
    }
}
