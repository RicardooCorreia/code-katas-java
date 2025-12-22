package code.wars.square_sum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(new int[]{1, 2, 2}, 9),
                Arguments.of(new int[]{0, 3, 4, 5}, 50),
                Arguments.of(new int[]{-1, -2, -3}, 14),
                Arguments.of(new int[]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void squareSum_examples(
            // Given
            int[] numbers,
            int expected
    ) {

        // When
        int result = Kata.squareSum(numbers);

        // Then
        assertEquals(expected, result);
    }
}
