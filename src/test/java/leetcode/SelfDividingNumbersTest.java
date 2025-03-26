package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SelfDividingNumbersTest {

    private final SelfDividingNumbers.Solution subject = new SelfDividingNumbers.Solution();

    @Test
    void selfDividingNumbers_example1() {

        // Given
        int left = 1;
        int right = 22;

        // When
        java.util.List<Integer> result = subject.selfDividingNumbers(left, right);

        // Then
        assertThat(result)
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22));
    }

    @Test
    void selfDividingNumbers_example2() {

        // Given
        int left = 47;
        int right = 85;

        // When
        java.util.List<Integer> result = subject.selfDividingNumbers(left, right);

        // Then
        assertThat(result)
                .isEqualTo(List.of(48, 55, 66, 77));
    }
}