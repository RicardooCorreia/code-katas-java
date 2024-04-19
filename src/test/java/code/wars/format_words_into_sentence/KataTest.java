package code.wars.format_words_into_sentence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new String[]{"one", "two", "three", "four"}, "one, two, three and four"),
                arguments(new String[]{"one"}, "one"),
                arguments(new String[]{"one", "", "three"}, "one and three"),
                arguments(new String[]{"", "", "three"}, "three"),
                arguments(new String[]{"one", "two", ""}, "one and two"),
                arguments(new String[]{}, ""),
                arguments(null, ""),
                arguments(new String[]{""}, ""));
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void formatWords_baseScenarios(
            // Given
            String[] input,
            String expected) {

        // When
        String result = Kata.formatWords(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
