package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleNumberTest {

    private final SingleNumber.Solution subject = new SingleNumber.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{2, 2, 1}, 1),
                Arguments.arguments(new int[]{4, 1, 2, 1, 2}, 4),
                Arguments.arguments(new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void singleNumber(
            // Given
            int[] input, int expected) {

        // When
        int result = subject.singleNumber(input);

        // Then
        assertEquals(expected, result);
    }
}