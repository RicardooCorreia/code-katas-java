package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstOccurrenceInAStringTest {

    private final FirstOccurrenceInAString.Solution subject = new FirstOccurrenceInAString.Solution();

    @Test
    void strStr_whenItExists_returnIndex() {

        // Given
        String haystack = "sadbutsad";
        String needle = "sad";

        // When
        int result = subject.strStr(haystack, needle);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void strStr_whenNeedleBiggerThanHayStack_returnIndex() {

        // Given
        String haystack = "aaa";
        String needle = "aaaa";

        // When
        int result = subject.strStr(haystack, needle);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    void strStr_whenItDoesNotExist_returnNegativeOne() {

        // Given
        String haystack = "leetcode";
        String needle = "leeto";

        // When
        int result = subject.strStr(haystack, needle);

        // Then
        assertThat(result)
                .isEqualTo(-1);
    }
}