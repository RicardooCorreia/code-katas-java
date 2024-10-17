package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumSwapTest {

    private final MaximumSwap.Solution subject = new MaximumSwap.Solution();

    @ParameterizedTest
    @CsvSource({
            "2736, 7236",
            "9973, 9973",
            "98368, 98863",
            "22341345, 52341342",
            "1993, 9913",
    })
    void maximumSwap(
            // Given
            int num,
            int expected) {

        // When
        int result = subject.maximumSwap(num);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}