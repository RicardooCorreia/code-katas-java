package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveCharactersTest {

    private final ConsecutiveCharacters.Solution subject = new ConsecutiveCharacters.Solution();

    @ParameterizedTest
    @CsvSource({
            "leetcode, 2",
            "abbcccddddeeeeedcba, 5",
    })
    void maxPower(
            // Given
            String s,
            int expected
    ) {

        // When
        int result = subject.maxPower(s);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}