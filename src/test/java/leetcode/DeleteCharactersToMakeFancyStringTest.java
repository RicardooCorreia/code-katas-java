package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteCharactersToMakeFancyStringTest {

    private final DeleteCharactersToMakeFancyString.Solution subject = new DeleteCharactersToMakeFancyString.Solution();

    @ParameterizedTest
    @CsvSource({
            "leeetcode, leetcode",
            "aaabaaaa, aabaa",
            "aab, aab"
    })
    void makeFancyString(
            // Given
            String s,
            String expected) {

        // When
        String result = subject.makeFancyString(s);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}