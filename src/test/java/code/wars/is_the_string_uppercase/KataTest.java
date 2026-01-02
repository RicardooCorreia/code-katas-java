package code.wars.is_the_string_uppercase;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KataTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "HELLO",
            "WORLD",
            "JAVA",
            "UPPERCASE",
            "TESTING",
            "HELLO I AM DONALD"
    })
    void isUpperCase_whenIsUpperCase_returnTrue(
            // Given
            String input) {

        // When
        boolean result = Kata.isUpperCase(input);

        // Then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Hello",
            "world",
            "Java",
            "UpperCase",
            "Testing",
            "Hello I am Donald",
            "mixed CASE",
            "123abc",
            "lowercase"
    })
    void isUpperCase_whenIsNotUpperCase_returnFalse(
            // Given
            String input) {

        // When
        boolean result = Kata.isUpperCase(input);

        // Then
        assertFalse(result);
    }
}
