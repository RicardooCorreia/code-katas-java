package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseVowelsOfStringTest {

    private final ReverseVowelsOfString.Solution subject = new ReverseVowelsOfString.Solution();

    @ParameterizedTest
    @CsvSource({
            "IceCreAm, AceCreIm",
            "hello, holle",
            "leetcode, leotcede"
    })
    void reverseVowels(
            // Given
            String input,
            String expected
    ) {

        // When
        String result = subject.reverseVowels(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}