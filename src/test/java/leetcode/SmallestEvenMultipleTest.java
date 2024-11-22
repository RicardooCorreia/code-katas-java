package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestEvenMultipleTest {

    private final SmallestEvenMultiple.Solution subject = new SmallestEvenMultiple.Solution();

    @ParameterizedTest
    @CsvSource({
            "5, 10",
            "6, 6",
    })
    void smallestEvenMultiple(
            // Given
            int n,
            int expected) {

        // When
        int result = subject.smallestEvenMultiple(n);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}