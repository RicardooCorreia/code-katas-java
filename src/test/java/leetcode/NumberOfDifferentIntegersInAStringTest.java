package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfDifferentIntegersInAStringTest {

    private final NumberOfDifferentIntegersInAString.Solution subject = new NumberOfDifferentIntegersInAString.Solution();

    @ParameterizedTest
    @CsvSource({
            "a123bc34d8ef34, 3",
            "leet1234code234, 2",
            "a1b01c001, 1",
            "0a0, 1"
    })
    void numDifferentIntegers(
            // Given
            String word,
            int expected) {

        // When
        int result = subject.numDifferentIntegers(word);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}