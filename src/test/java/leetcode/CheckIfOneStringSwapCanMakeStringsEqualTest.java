package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfOneStringSwapCanMakeStringsEqualTest {

    private final CheckIfOneStringSwapCanMakeStringsEqual.Solution subject = new CheckIfOneStringSwapCanMakeStringsEqual.Solution();

    @Test
    void areAlmostEqual() {

        // Given
        String s1 = "bank";
        String s2 = "kanb";

        // When
        boolean result = subject.areAlmostEqual(s1, s2);

        // Then
        assertTrue(result);
    }

    @Test
    void areNotAlmostEqual() {

        // Given
        String s1 = "attack";
        String s2 = "defend";

        // When
        boolean result = subject.areAlmostEqual(s1, s2);

        // Then
        assertFalse(result);
    }

    @Test
    void areAlreadyEqual() {

        // Given
        String s1 = "kelb";
        String s2 = "kelb";

        // When
        boolean result = subject.areAlmostEqual(s1, s2);

        // Then
        assertTrue(result);
    }

    @Test
    void areAlmostEqual_baseExample() {

        // Given
        String s1 = "aa";
        String s2 = "ac";

        // When
        boolean result = subject.areAlmostEqual(s1, s2);

        // Then
        assertFalse(result);
    }
}