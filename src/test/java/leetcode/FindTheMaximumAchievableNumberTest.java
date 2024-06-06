package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindTheMaximumAchievableNumberTest {

    private final FindTheMaximumAchievableNumber.Solution subject = new FindTheMaximumAchievableNumber.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
            Arguments.arguments(4, 1, 6),
            Arguments.arguments(3, 2, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void theMaximumAchievableX(
            // Given
            int n, int x, int expected) {

        // When
        int result = subject.theMaximumAchievableX(n, x);

        // Then
        assertEquals(expected, result);
    }
}