package haker.rank.between_two_sets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void getTotalX_example() {

        // Given
        List<Integer> a = List.of(2, 4);
        List<Integer> b = List.of(16, 32, 96);

        // When
        int result = Result.getTotalX(a, b);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }
}
