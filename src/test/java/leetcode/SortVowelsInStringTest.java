package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SortVowelsInStringTest {

    private final SortVowelsInString.Solution subject = new SortVowelsInString.Solution();

    @ParameterizedTest
    @CsvSource({"lEetcOde,lEOtcede", "lYmpH,lYmpH"})
    void sortVowels(
            // Given
            String input,
            String expected) {

        // When
        String result = subject.sortVowels(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}