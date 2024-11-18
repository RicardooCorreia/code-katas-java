package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefuseTheBombTest {

    private final DefuseTheBomb.Solution subject = new DefuseTheBomb.Solution();

    @Test
    void decrypt_whenKIsPositive_returnCorrectSolution() {

        // Given
        int[] code = {5, 7, 1, 4};
        int k = 3;

        // When
        int[] result = subject.decrypt(code, k);

        // Then
        assertThat(result)
                .containsExactly(12, 10, 16, 13);
    }

    @Test
    void decrypt_whenKIsZero_returnZero() {

        // Given
        int[] code = {1, 2, 3, 4};
        int k = 0;

        // When
        int[] result = subject.decrypt(code, k);

        // Then
        assertThat(result)
                .containsExactly(0, 0, 0, 0);
    }

    @Test
    void decrypt_whenKIsNegative_returnCorrectSolution() {

        // Given
        int[] code = {2, 4, 9, 3};
        int k = -2;

        // When
        int[] result = subject.decrypt(code, k);

        // Then
        assertThat(result)
                .containsExactly(12, 5, 6, 13);
    }
}