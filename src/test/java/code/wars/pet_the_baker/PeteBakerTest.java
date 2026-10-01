package code.wars.pet_the_baker;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PeteBakerTest {

    @Test
    void should_returnTwo_when_ingredientsAllowTwoCakes() {
        // given
        Map<String, Integer> recipe = Map.of(
            "flour", 500,
            "sugar", 200,
            "eggs", 1);
        Map<String, Integer> available = Map.of(
            "flour", 1200,
            "sugar", 1200,
            "eggs", 5,
            "milk", 200);

        // when
        int result = PeteBaker.cakes(recipe, available);
        int result2 = PeteBaker.cakesFunctional(recipe, available);

        // then
        assertThat(result)
            .as("For recipe %s and ingredients %s", recipe, available)
            .isEqualTo(2)
            .isEqualTo(result2);
    }

    @Test
    void should_returnZero_when_recipeIngredientIsMissing() {
        // given
        Map<String, Integer> recipe = Map.of(
            "flour", 500,
            "sugar", 200,
            "eggs", 1,
            "cinnamon", 300);
        Map<String, Integer> available = Map.of(
            "flour", 1200,
            "sugar", 1200,
            "eggs", 5,
            "milk", 200);

        // when
        int result = PeteBaker.cakes(recipe, available);
        int result2 = PeteBaker.cakesFunctional(recipe, available);

        // then
        assertThat(result)
            .as("For recipe %s and ingredients %s", recipe, available)
            .isEqualTo(0)
            .isEqualTo(result2);
    }
}
