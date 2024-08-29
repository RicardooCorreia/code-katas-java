package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateStringTest {

    private final RotateString.Solution subject = new RotateString.Solution();
    private final RotateString.Solution2 subject2 = new RotateString.Solution2();

    @Test
    void rotateString_whenCanRotate_returnTrue() {

        // Given
        String input = "abcde";
        String goal = "cdeab";

        // When
        boolean result = subject.rotateString(input, goal);
        boolean result2 = subject2.rotateString(input, goal);

        // Then
        assertTrue(result);
        assertTrue(result2);
    }

    @Test
    void rotateString_whenCannotRotate_returnFalse() {

        // Given
        String input = "abcde";
        String goal = "abced";

        // When
        boolean result = subject.rotateString(input, goal);
        boolean result2 = subject2.rotateString(input, goal);

        // Then
        assertFalse(result);
        assertFalse(result2);
    }

    @Test
    void rotateString_whenCannotRotateComplexExample_returnFalse() {

        // Given
        String input = "defdefdefabcabc";
        String goal = "defdefabcabcdef";

        // When
        boolean result = subject.rotateString(input, goal);
        boolean result2 = subject2.rotateString(input, goal);

        // Then
        assertTrue(result);
        assertTrue(result2);
    }
}