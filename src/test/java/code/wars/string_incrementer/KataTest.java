package code.wars.string_incrementer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("foobar000", "foobar001"),
                arguments("foo", "foo1"),
                arguments("foobar001", "foobar002"),
                arguments("foobar99", "foobar100"),
                arguments("foobar099", "foobar100"),
                arguments("", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void incrementString_baseTests(
            // Given
            String input,
            String expected) {

        // When
        final String result = Kata.incrementString(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void incrementString_whenNull_returnNull() {

        // Given
        final String str = null;

        // When
        final String result = Kata.incrementString(str);

        // Then
        assertThat(result)
                .isEqualTo(null);
    }

    @Test
    void incrementString_whenBlank_returnSpacesWithNumber() {

        // Given
        final String str = "         ";

        // When
        final String result = Kata.incrementString(str);

        // Then
        assertThat(result)
                .isEqualTo("         1");
    }

    @Test
    void incrementString_whenMultipleNumbers_returnCorrectNumbers() {

        // Given
        final String str = "123Hey545Foo99";

        // When
        final String result = Kata.incrementString(str);

        // Then
        assertThat(result)
                .isEqualTo("123Hey545Foo100");
    }

    @Test
    void incrementString_whenLargeNumber_returnCorrectNumbers() {

        // Given
        final String str = "0000000350939464706842318767";

        // When
        final String result = Kata.incrementString(str);

        // Then
        assertThat(result)
                .isEqualTo("0000000350939464706842318768");
    }
}
