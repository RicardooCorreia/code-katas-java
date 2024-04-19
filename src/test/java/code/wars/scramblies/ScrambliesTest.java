package code.wars.scramblies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScrambliesTest {

    @Test
    void scrambles_whenCanBeRearranged_returnTrue() {

        // Given
        final String string1 = "rkqodlw";
        final String string2 = "world";

        // When
        final boolean result = Scramblies.scramble(string1, string2);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void scrambles_whenPortionCanBeRearranged_returnTrue() {

        // Given
        final String string1 = "cedewaraaossoqqyt";
        final String string2 = "codewars";

        // When
        final boolean result = Scramblies.scramble(string1, string2);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void scrambles_whenCanNotBeRearranged_returnTrue() {

        // Given
        final String string1 = "katas";
        final String string2 = "steak";

        // When
        final boolean result = Scramblies.scramble(string1, string2);

        // Then
        assertThat(result)
                .isFalse();
    }
}