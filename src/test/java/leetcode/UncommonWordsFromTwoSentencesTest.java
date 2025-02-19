package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UncommonWordsFromTwoSentencesTest {

    private final UncommonWordsFromTwoSentences.Solution subject = new UncommonWordsFromTwoSentences.Solution();

    @ParameterizedTest
    @CsvSource({
            "this apple is sweet, this apple is sour,sweet sour",
            "apple apple,banana,banana",
            "apple banana,banana,apple",
            "s z z z s,s z ejt,ejt",
    })
    void uncommonFromSentences(
            // Given
            String input1,
            String input2,
            String expected) {

        // When
        String[] result = subject.uncommonFromSentences(input1, input2);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(expected.split(" "));
    }
}