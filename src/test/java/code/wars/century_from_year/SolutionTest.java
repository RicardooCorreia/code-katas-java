package code.wars.century_from_year;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1705, 18",
            "1900, 19",
            "1601, 17",
            "2000, 20",
            "89, 1"
    })
    public void century_baseScenarios(
            // Given
            int input,
            int expected) {

        // When
        int result = Solution.century(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
