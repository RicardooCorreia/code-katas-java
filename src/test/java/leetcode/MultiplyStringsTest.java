package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyStringsTest {

    private final MultiplyStrings.Solution subject = new MultiplyStrings.Solution();

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "123, 456, 56088",
            "123456789, 987654321, 121932631112635269"
    })
    void multiply_examples(
            // Given
            String num1,
            String num2,
            String expected) {

        // When
        String result = subject.multiply(num1, num2);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}