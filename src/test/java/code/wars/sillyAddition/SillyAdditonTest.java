package code.wars.sillyAddition;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SillyAdditonTest {

    @ParameterizedTest
    @CsvSource(value =
            {
                    "16,18,214",
                    "26,39,515",
                    "72,9,711",
                    "122,81,1103",
            })
    void add_examples(
            // Given
            int num1,
            int num2,
            int expectedResult) {

        // When
        int result = SillyAdditon.add(num1, num2);

        // Then
        assertThat(result)
                .isEqualTo(expectedResult);
    }
}
