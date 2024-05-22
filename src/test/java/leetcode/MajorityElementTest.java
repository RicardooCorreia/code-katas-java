package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    private final MajorityElement.Solution subject = new MajorityElement.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
            Arguments.of(new int[]{3, 2, 3}, 3),
            Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2));
    }

    @ParameterizedTest
    @MethodSource("examples")
    void majorityElement(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.majorityElement(input);

        // Then
        assertEquals(expected, result);
    }
}