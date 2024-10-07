package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumStringLengthAfterRemovingSubstringTest {

    private final MinimumStringLengthAfterRemovingSubstring.Solution subject = new MinimumStringLengthAfterRemovingSubstring.Solution();

    @Test
    void minLength_whenHasSubstring_returnMinLength() {

        // Given
        String input = "ABFCACDB";

        // When
        int result = subject.minLength(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void minLength_whenDoesNotHaveSubstring_returnSameLength() {

        // Given
        String input = "ACBBD";

        // When
        int result = subject.minLength(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }
}