package code.wars.reverse_words;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("The quick brown fox jumps over the lazy dog.", "ehT kciuq nworb xof spmuj revo eht yzal .god"),
                arguments("apple", "elppa"),
                arguments("a b c d", "a b c d"),
                arguments("double  spaced  words", "elbuod  decaps  sdrow")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void reverseWords_baseScenarios(
            // Given
            String input,
            String expected) {

        // When
        final String result = Kata.reverseWords(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
