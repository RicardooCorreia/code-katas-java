package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LemonadeChangeTest {

    private final LemonadeChange.Solution subject = new LemonadeChange.Solution();

    @Test
    void lemonadeChange_whenIsPossibleToGiveChange_returnTrue() {

        // Given
        int[] bills = {5, 5, 5, 10, 20};

        // When
        boolean result = subject.lemonadeChange(bills);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void lemonadeChange_whenIsNotPossibleToGiveChange_returnFalse() {

        // Given
        int[] bills = {5, 5, 10, 10, 20};

        // When
        boolean result = subject.lemonadeChange(bills);

        // Then
        assertThat(result).isFalse();
    }
}