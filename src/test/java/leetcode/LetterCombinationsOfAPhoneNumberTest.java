package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LetterCombinationsOfAPhoneNumberTest {

    private LetterCombinationsOfAPhoneNumber.Solution subject = new LetterCombinationsOfAPhoneNumber.Solution();

    @Test
    void letterCombinations() {

        // Given
        String input = "23";

        // When
        List<String> result = subject.letterCombinations(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }

    @Test
    void letterCombinations_whenEmpty_returnEmpty() {

        // Given
        String input = "";

        // When
        List<String> result = subject.letterCombinations(input);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void letterCombinations_whenSingleNumber_returnLetters() {

        // Given
        String input = "2";

        // When
        List<String> result = subject.letterCombinations(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("a", "b", "c");
    }
}