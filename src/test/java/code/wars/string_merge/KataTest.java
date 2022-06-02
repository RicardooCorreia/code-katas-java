package code.wars.string_merge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("person", "here", 'e', "pere"),
                arguments("apowiejfoiajsf", "iwahfeijouh", 'j', "apowiejouh"),
                arguments("abcdefxxxyzz", "abcxxxyyyxyzz", 'x', "abcdefxxxyyyxyzz")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void stringMerge_baseTests(
            // Given
            String string1,
            String string2,
            char pointOfMerge,
            String expected) {

        // When
        final String result = Kata.stringMerge(string1, string2, pointOfMerge);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
