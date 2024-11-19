package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SortingTheSentenceTest {

    private final SortingTheSentence.Solution subject = new SortingTheSentence.Solution();

    @ParameterizedTest
    @CsvSource({
            "is2 sentence4 This1 a3, This is a sentence",
            "Myself2 Me1 I4 and3, Me Myself and I"
    })
    void sortSentence(
            // Given
            String s,
            String expected) {

        // When
        String result = subject.sortSentence(s);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}