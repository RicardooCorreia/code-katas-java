package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NimGameTest {

    private final NimGame.Solution solution = new NimGame.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(4, false),
                Arguments.arguments(1, true),
                Arguments.arguments(2, true)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void canWinNim(
            // Given
            int input,
            boolean expected) {

        // When
        boolean result = solution.canWinNim(input);

        // Then
        assertEquals(expected, result);
    }
}