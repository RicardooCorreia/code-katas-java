package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllPossibleRecipesFromGivenSuppliesTest {

    private final FindAllPossibleRecipesFromGivenSupplies.Solution subject = new FindAllPossibleRecipesFromGivenSupplies.Solution();

    @Test
    void findAllRecipes_whenSimpleRecipe_returnPossible() {

        // Given
        String[] recipes = {"bread"};
        List<List<String>> ingredients = List.of(List.of("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "corn"};

        // When
        List<String> result = subject.findAllRecipes(recipes, ingredients, supplies);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("bread");
    }

    @Test
    void findAllRecipes_whenSimpleRecipes_returnMultiplePossible() {

        // Given
        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = List.of(List.of("yeast", "flour"), List.of("bread", "meat"));
        String[] supplies = {"yeast", "flour", "meat"};

        // When
        List<String> result = subject.findAllRecipes(recipes, ingredients, supplies);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("bread", "sandwich");
    }

    @Test
    void findAllRecipes_whenComplexRecipes_returnPossible() {

        // Given
        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = List.of(List.of("yeast", "flour"), List.of("bread", "meat"), List.of("sandwich", "meat", "bread"));
        String[] supplies = {"yeast", "flour", "meat"};

        // When
        List<String> result = subject.findAllRecipes(recipes, ingredients, supplies);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("bread", "sandwich", "burger");
    }
}