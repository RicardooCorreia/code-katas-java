package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicate2Test {

    private final ContainsDuplicate2.Solution subject = new ContainsDuplicate2.Solution();

    public static Stream<Arguments> duplicateExamples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 1}, 3),
                Arguments.arguments(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateExamples")
    void containsNearbyDuplicate(
            // Given
            int[] input,
            int k
    ) {

        // When
        boolean result = subject.containsNearbyDuplicate(input, k);

        // Then
        assertTrue(result);
    }

    @Test
    void containsNearbyDuplicate_whenDoesNotHaveDuplicate() {

        // Given
        int[] input = {1, 2, 3, 1, 2, 3};
        int k = 2;

        // When
        boolean result = subject.containsNearbyDuplicate(input, k);

        // Then
        assertFalse(result);
    }
}