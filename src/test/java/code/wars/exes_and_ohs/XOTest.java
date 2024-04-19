package code.wars.exes_and_ohs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class XOTest {

    @Test
    void getXO_whenHasSameAmountOfOsAndXs_isTrue() {

        // Given
        final String input = "xxxooo";

        // When
        final boolean result = XO.getXO(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void getXO_whenHasMoreOsThanXs_isFalse() {

        // Given
        final String input = "xxxoooo";

        // When
        final boolean result = XO.getXO(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void getXO_whenHasMoreXsThanOs_isFalse() {

        // Given
        final String input = "xxxxooo";

        // When
        final boolean result = XO.getXO(input);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void getXO_whenSameAmountOfXsAndOsButHasOtherLetters_isTrue() {

        // Given
        final String input = "xhjdsaodsaxdasdaodsaogfgfx";

        // When
        final boolean result = XO.getXO(input);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void getXO_whenSameAmountOfXsAndOsButAreDifferentCases_isTrue() {

        // Given
        final String input = "xOxOoXXo";

        // When
        final boolean result = XO.getXO(input);

        // Then
        assertThat(result)
                .isTrue();
    }
}