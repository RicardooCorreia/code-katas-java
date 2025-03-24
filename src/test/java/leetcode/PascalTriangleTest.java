package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PascalTriangleTest {

    private PascalTriangle.Solution subject = new PascalTriangle.Solution();

    @Test
    void generate_multipleRows() {

        // Given
        int numRows = 5;

        // When
        List<List<Integer>> result = subject.generate(numRows);

        // Then
        assertThat(result)
                .containsExactly(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1),
                        List.of(1, 3, 3, 1),
                        List.of(1, 4, 6, 4, 1)
                );
    }

    @Test
    void generate_singleRow() {

        // Given
        int numRows = 1;

        // When
        List<List<Integer>> result = subject.generate(numRows);

        // Then
        assertThat(result)
                .containsExactly(
                        List.of(1)
                );
    }
}