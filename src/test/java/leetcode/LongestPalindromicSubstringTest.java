package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromicSubstringTest {

    private static final LongestPalindromicSubstring.Solution subject = new LongestPalindromicSubstring.Solution();

    @Test
    void longestPalindrome_example1() {

        // Given
        String input = "babad";

        // When
        String result = subject.longestPalindrome(input);

        // Then
        assertThat(result)
                .isIn("bab", "aba");
    }

    @Test
    void longestPalindrome_example2() {

        // Given
        String input = "cbbd";

        // When
        String result = subject.longestPalindrome(input);

        // Then
        assertThat(result)
                .isEqualTo("bb");
    }

    @Test
    void longestPalindrome_whenMultiplePalindrome_returnBiggestOne() {

        // Given
        String input = "aaaaaaaaaaaa";

        // When
        String result = subject.longestPalindrome(input);

        // Then
        assertThat(result)
                .isEqualTo("aaaaaaaaaaaa");
    }

    @Test
    void longestPalindrome_whenFindsLastLettersButIsNotPalindrome_returnsCorrectOne() {

        // Given
        String input = "aaaaaaaaaaaaba";

        // When
        String result = subject.longestPalindrome(input);

        // Then
        assertThat(result)
                .isEqualTo("aaaaaaaaaaaa");
    }

    @Test
    void longestPalindrome_simpleInput_returnCorrect() {

        // Given
        String input = "a";

        // When
        String result = subject.longestPalindrome(input);

        // Then
        assertThat(result)
                .isEqualTo("a");
    }

    @Test
    void longestPalindrome_twoLetterInput_returnCorrect() {

        // Given
        String input = "ac";

        // When
        String result = subject.longestPalindrome(input);

        // Then
        assertThat(result)
                .isEqualTo("a");
    }
}