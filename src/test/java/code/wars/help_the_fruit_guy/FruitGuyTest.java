package code.wars.help_the_fruit_guy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FruitGuyTest {

    @Test
    public void removeRotten_whenEmpty_returnEmpty() {

        // Given
        final String[] input = new String[0];

        // When
        final String[] result = FruitGuy.removeRotten(input);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    public void removeRotten_whenNull_returnNull() {

        // Given
        final String[] input = null;

        // When
        final String[] result = FruitGuy.removeRotten(input);

        // Then
        assertThat(result)
                .isNull();
    }

    @Test
    public void removeRotten_whenHasRottenFruit_returnBasketWithReplacedFruit() {

        // Given
        final String[] input = new String[]{"rottenApple", "rottenBanana", "rottenApple", "rottenPineapple", "rottenKiwi"};

        // When
        final String[] result = FruitGuy.removeRotten(input);

        // Then
        assertThat(result)
                .containsExactly("apple", "banana", "apple", "pineapple", "kiwi");
    }
}
