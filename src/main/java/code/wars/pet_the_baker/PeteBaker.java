package code.wars.pet_the_baker;

import java.util.Map;

import static java.lang.Math.min;

public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe,
                            Map<String, Integer> available) {

        if (recipe.isEmpty() || available.isEmpty()) {
            return 0;
        }

        int possibleCakes = Integer.MAX_VALUE;

        for (var recipeEntry : recipe.entrySet()) {
            final var availableIngredient = available.getOrDefault(recipeEntry.getKey(), 0);
            possibleCakes = min(possibleCakes, availableIngredient / recipeEntry.getValue());
        }

        return possibleCakes;
    }

    public static int cakesFunctional(Map<String, Integer> recipe,
                                      Map<String, Integer> available) {

        if (recipe.isEmpty() || available.isEmpty()) {
            return 0;
        }

        return recipe.entrySet()
            .stream()
            .mapToInt(entry -> {
                final var availableIngredient = available.getOrDefault(entry.getKey(), 0);
                return availableIngredient / entry.getValue();
            })
            .min()
            .orElseThrow();
    }
}
