package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseOnlyLettersTest {

    private final ReverseOnlyLetters.Solution subject = new ReverseOnlyLetters.Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "ab-cd,dc-ba",
            "a-bC-dEf-ghIj,j-Ih-gfE-dCba",
            "Test1ng-Leet=code-Q!,Qedo1ct-eeLg=ntse-T!"
    }, delimiter = ',')
    void reverseOnlyLetters(
            // Given
            String input,
            String expected) {

        // When
        String result = subject.reverseOnlyLetters(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}