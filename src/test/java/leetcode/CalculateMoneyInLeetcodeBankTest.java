package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateMoneyInLeetcodeBankTest {

    private final CalculateMoneyInLeetcodeBank.Solution subject = new CalculateMoneyInLeetcodeBank.Solution();

    @ParameterizedTest
    @CsvSource({"4,10", "10,37", "20,96"})
    void totalMoney(
            // Given
            int input,
            int expected) {

        // When
        int result = subject.totalMoney(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}