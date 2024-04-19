package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsomorphicStringsTest {

    private final IsomorphicStrings.Solution subject = new IsomorphicStrings.Solution();

    public static Stream<Arguments> examplesIsomorphic() {

        return Stream.of(
                Arguments.arguments("egg", "add"),
                Arguments.arguments("paper", "title")
        );
    }

    public static Stream<Arguments> examplesNotIsomorphic() {

        return Stream.of(
                Arguments.arguments("foo", "bar"),
                Arguments.arguments("badc", "baba")
        );
    }

    @ParameterizedTest
    @MethodSource("examplesIsomorphic")
    void isIsomorphic_trueExamples(
            // Given
            String input1,
            String input2) {

        // When
        boolean result = subject.isIsomorphic(input1, input2);

        // Then
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("examplesNotIsomorphic")
    void isIsomorphic_whenNotIsomorphic_returnFalse(
            // Given
            String input1,
            String input2) {

        // When
        boolean result = subject.isIsomorphic(input1, input2);

        // Then
        assertFalse(result);
    }
}