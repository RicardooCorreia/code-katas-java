package code.wars.multiples_of_3_and_5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution subject = new Solution();

    @Test
    void solution_whenHasMultipleNumbers_returnSum() {

        // Given
        final int input = 10;

        // When
        final int result = subject.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(23);
    }

    @Test
    void solution_whenNumberIsNegative_return0() {

        // Given
        final int input = -1;

        // When
        final int result = subject.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(0);

    }

    @Test
    void solution_whenHasNotNumbers_return0() {

        // Given
        final int input = 2;

        // When
        final int result = subject.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(0);

    }
}