package code.wars.smallest_in_array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArraysTest {

    @Test
    public void findSmallest_whenIsValue_returnSmallestValue() {

        // Given
        final int[] input = {7, 12, 3, 2, 27};
        final String toReturn = "value";

        // When
        final int result = Arrays.findSmallest(input, toReturn);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    public void findSmallest_whenIsIndex_returnIndexOfSmallestValue() {

        // Given
        final int[] input = {7, 12, 3, 2, 27};
        final String toReturn = "index";

        // When
        final int result = Arrays.findSmallest(input, toReturn);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }
}
