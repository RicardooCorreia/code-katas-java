package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

    private final ContainsDuplicate.Solution subject = new ContainsDuplicate.Solution();

    public static Stream<Arguments> duplicateExamples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 1}),
                Arguments.arguments(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateExamples")
    void containsDuplicate_whenHasDuplicates_returnTrue(
            // Given
            int[] input) {

        // When
        boolean result = subject.containsDuplicate(input);

        // Then
        assertTrue(result);
    }

    @Test
    void containsDuplicate_whenDoesNotHaveDuplicate_returnFalse() {

        // Given
        int[] input = {1, 2, 3, 4};

        // When
        boolean result = subject.containsDuplicate(input);

        // Then
        assertFalse(result);
    }
}