package code.wars.break_camel_case;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void camelCase_whenHasCamelCase_breakWords() {

        // Given
        final String input = "camelCasing";

        // When
        final String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("camel Casing");
    }

    @Test
    void camelCase_whenHasMultipleWords_breakWords() {

        // Given
        final String input = "camelCasingIsSoCool";

        // When
        final String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("camel Casing Is So Cool");
    }

    @Test
    void camelCase_whenIsSingleWord_returnSame() {

        // Given
        final String input = "single";

        // When
        final String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("single");
    }

    @Test
    void camelCase_whenIsEmptyWord_returnEmpty() {

        // Given
        final String input = "";

        // When
        final String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}