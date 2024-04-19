package code.wars.convert_string_to_camel_case;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void toCamelCase_replacesUnderscores() {

        // Given
        final String input = "the_Stealth_Warrior";

        // When
        final String result = Solution.toCamelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("theStealthWarrior");
    }

    @Test
    public void toCamelCase_replacesDashes() {

        // Given
        final String input = "The-Stealth-Warrior";

        // When
        final String result = Solution.toCamelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("TheStealthWarrior");
    }

    @Test
    public void toCamelCase_whenJustOneWord_returnSame() {

        // Given
        final String input = "warrior";

        // When
        final String result = Solution.toCamelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("warrior");
    }

    @Test
    public void toCamelCase_whenJustOneWords_returnCamel() {

        // Given
        final String input = "a-e-i-o-u";

        // When
        final String result = Solution.toCamelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("aEIOU");
    }

    @Test
    public void toCamelCase_whenEmpty_returnEmpty() {

        // Given
        final String input = "";

        // When
        final String result = Solution.toCamelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}
