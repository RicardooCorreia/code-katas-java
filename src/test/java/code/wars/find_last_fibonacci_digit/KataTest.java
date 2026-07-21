package code.wars.find_last_fibonacci_digit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static code.wars.find_last_fibonacci_digit.Kata.lastFibDigit;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "21, 6",
        "302, 1",
        "4003, 7",
        "50004, 8",
        "600005, 5",
        "7000006, 3",
        "80000007, 8",
        "900000008, 1",
        "1000000009, 9"
    })
    void should_returnLastFibonacciDigit_when_nGiven(
        // given
        int n, int expected) {

        // when
        var result = lastFibDigit(n);

        // then
        assertThat(result).isEqualTo(expected);
    }
}