package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients.
 The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i].
  A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.
You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
Return a list of all the recipes that you can create. You may return the answer in any order.
Note that two recipes may contain each other in their ingredients.

Example 1:
    Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
    Output: ["bread"]
    Explanation:
        We can create "bread" since we have the ingredients "yeast" and "flour".
Example 2:
    Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
    Output: ["bread","sandwich"]
    Explanation:
        We can create "bread" since we have the ingredients "yeast" and "flour".
        We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
Example 3:
    Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
    Output: ["bread","sandwich","burger"]
    Explanation:
        We can create "bread" since we have the ingredients "yeast" and "flour".
        We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
        We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".

Constraints:
    n == recipes.length == ingredients.length
    1 <= n <= 100
    1 <= ingredients[i].length, supplies.length <= 100
    1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
    recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
    All the values of recipes and supplies combined are unique.
    Each ingredients[i] does not contain any duplicate values.
 */
public class FindAllPossibleRecipesFromGivenSupplies {

    static class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

            Set<String> suppiesSet = Arrays.stream(supplies)
                    .collect(Collectors.toSet());
            Set<Recipe> missingRecipes = new HashSet<>();
            List<String> possibleRecipes = new LinkedList<>();

            for (int i = 0; i < recipes.length; i++) {
                String recipe = recipes[i];
                missingRecipes.add(new Recipe(recipe, ingredients.get(i)));
            }

            do {
                List<Recipe> recipesDone = new LinkedList<>();
                for (Recipe recipe : missingRecipes) {
                    boolean isPossible = suppiesSet.containsAll(recipe.ingredients());
                    if (isPossible) {
                        recipesDone.add(recipe);
                        possibleRecipes.add(recipe.name());
                        suppiesSet.add(recipe.name());
                    }
                }

                if (!recipesDone.isEmpty()) {
                    recipesDone.forEach(missingRecipes::remove);
                } else {
                    break; // no more recipes are possible
                }

            } while (!missingRecipes.isEmpty());


            return possibleRecipes;
        }

        public record Recipe(String name, List<String> ingredients) {
        }
    }

    static class Solution2 {
        public List<String> findAllRecipes(String[] recipes,
                                           List<List<String>> ingredients,
                                           String[] supplies) {

            Map<String, RecipeInfo> cookbook = getRecipesMap(recipes, ingredients);
            Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
            Set<String> triedRecipes = new HashSet<>();

            for (String recipe : recipes) {
                makeRecipe(recipe, suppliesSet, cookbook, triedRecipes);
            }

            return cookbook.entrySet().stream()
                    .filter(recipe -> recipe.getValue().isPossible())
                    .map(Map.Entry::getKey)
                    .toList();
        }

        private boolean makeRecipe(String recipe, Set<String> supplies, Map<String, RecipeInfo> cookbook, Set<String> triedRecipes) {

            if (triedRecipes.contains(recipe)) {
                return Boolean.TRUE == cookbook.get(recipe).isPossible();
            }

            triedRecipes.add(recipe);

            if (supplies.contains(recipe)) {
                return true;
            }

            RecipeInfo recipeInfo = cookbook.get(recipe);
            if (recipeInfo.isPossible() != null) {
                return recipeInfo.isPossible();
            }

            List<String> ingredients = recipeInfo.ingredients();
            for (String ingredient : ingredients) {
                if (cookbook.containsKey(ingredient)) {
                    RecipeInfo recipeIngredientInfo = cookbook.get(ingredient);
                    if (recipeIngredientInfo.isPossible() != null) {
                        if (!recipeIngredientInfo.isPossible()) {
                            cookbook.put(recipe, new RecipeInfo(ingredients, false));
                            return false;
                        }
                    } else if (!makeRecipe(ingredient, supplies, cookbook, triedRecipes)) {
                        cookbook.put(recipe, new RecipeInfo(ingredients, false));
                        return false;
                    }
                } else if (!supplies.contains(ingredient)) {
                    cookbook.put(recipe, new RecipeInfo(ingredients, false));
                    return false;
                }
            }

            cookbook.put(recipe, new RecipeInfo(ingredients, true));
            return true;
        }

        private static Map<String, RecipeInfo> getRecipesMap(String[] recipes, List<List<String>> ingredients) {
            Map<String, RecipeInfo> recipesMap = new HashMap<>();
            for (int i = 0; i < recipes.length; i++) {
                recipesMap.put(recipes[i], new RecipeInfo(ingredients.get(i), null));
            }
            return recipesMap;
        }

        public record RecipeInfo(List<String> ingredients, Boolean isPossible) {
        }
    }
}
