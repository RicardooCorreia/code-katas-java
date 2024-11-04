package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCompressionIIITest {

    private StringCompressionIII.Solution subject = new StringCompressionIII.Solution();

    @Test
    void compressedString() {

        // Given
        String input = "abcde";

        // When
        String result = subject.compressedString(input);

        // Then
        assertThat(result)
                .isEqualTo("1a1b1c1d1e");
    }

    @Test
    void compressedString2() {

        // Given
        String input = "aaaaaaaaaaaaaabb";

        // When
        String result = subject.compressedString(input);

        // Then
        assertThat(result)
                .isEqualTo("9a5a2b");
    }
}