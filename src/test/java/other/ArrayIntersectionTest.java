package other;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayIntersectionTest {

    @Test
    void intersection_whenHasIntersection_returnNumbers() {

        // Given
        ArrayIntersection subject = new ArrayIntersection();

        Integer[] inputA = {3, 4, 2, 7, 9};
        Integer[] inputB = {6, 1, 9, 3, 0};

        // When
        Integer[] result = subject.intersection(inputA, inputB);

        // Then
        assertThat(result)
                .containsOnly(3, 9);
    }

    @Test
    void intersection_whenHasNoIntersection_returnEmpty() {

        // Given
        ArrayIntersection subject = new ArrayIntersection();

        Integer[] inputA = {1, 5, 2, 9, 4};
        Integer[] inputB = {0, 6, 11, 7, 3};

        // When
        Integer[] result = subject.intersection(inputA, inputB);

        // Then
        assertThat(result)
                .isEmpty();
    }
}
