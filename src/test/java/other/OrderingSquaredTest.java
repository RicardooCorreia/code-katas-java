package other;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderingSquaredTest {

    private final OrderingSquared subject = new OrderingSquared();

    @Test
    void squareAndOrder_whenEmpty_returnEmpty() {

        // Given
        List<Integer> input = List.of();

        // When
        List<Integer> result = subject.squareAndOrder(input);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void squareAndOrder_whenSingleNumber_returnSquaredNumber() {

        // Given
        List<Integer> input = List.of(2);

        // When
        List<Integer> result = subject.squareAndOrder(input);

        // Then
        assertThat(result)
                .containsExactly(4);
    }

    @Test
    void squareAndOrder_whenMultipleNumbers_returnSquaredNumbers() {

        // Given
        List<Integer> input = List.of(1, 2, 4);

        // When
        List<Integer> result = subject.squareAndOrder(input);

        // Then
        assertThat(result)
                .containsExactly(1, 4, 16);
    }

    @Test
    void squareAndOrder_whenMultipleNegativeNumbers_returnSquaredNumbers() {

        // Given
        List<Integer> input = List.of(-4, -3, -2);

        // When
        List<Integer> result = subject.squareAndOrder(input);

        // Then
        assertThat(result)
                .containsExactly(4, 9, 16);
    }

    @Test
    void squareAndOrder_whenNegativeAndPositiveNumber_returnSquaredNumbers() {

        // Given
        List<Integer> input = List.of(-1, 1);

        // When
        List<Integer> result = subject.squareAndOrder(input);

        // Then
        assertThat(result)
                .containsExactly(1, 1);
    }

    @Test
    void squareAndOrder_whenMixedNumber_returnCorrectNumbers() {

        // Given
        List<Integer> input = List.of(-4, -3, -2, 0, 2, 3, 4);

        // When
        List<Integer> result = subject.squareAndOrder(input);

        // Then
        assertThat(result)
                .containsExactly(0, 4, 4, 9, 9, 16, 16);
    }
}
