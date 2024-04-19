package code.wars.remove_the_parentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @CsvSource({
            "example(unwanted thing)example,exampleexample",
            "example(unwanted thing)example,exampleexample",
            "example (unwanted thing) example,example  example",
            "a (bc d)e,a e",
            "a(b(c)),a",
            "hello example (words(more words) here) something,hello example  something"
    })
    public void removeParentheses_baseScenarios(
            // Given
            String input,
            String expected) {

        // When
        String result = Kata.removeParentheses(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    public void removeParentheses_whenBecomesEmpty_returnEmtpy() {

        // Given
        String input = "(first group) (second group) (third group)";

        // When
        String result = Kata.removeParentheses(input);

        // Then
        assertThat(result)
                .isEqualTo("  ");
    }
}
