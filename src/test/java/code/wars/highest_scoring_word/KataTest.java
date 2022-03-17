package code.wars.highest_scoring_word;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> testScenarios() {

        return Stream.of(
                arguments("man i need a taxi up to ubud", "taxi"),
                arguments("what time are we climbing up to the volcano", "volcano"),
                arguments("take me to semynak", "semynak")
        );
    }

    @ParameterizedTest
    @MethodSource("testScenarios")
    public void high_baseScenarios(
            // Given
            String input,
            String expected) {

        // When
        final String result = Kata.high(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void high_whenScoresTheSamePoints_returnTheFirstWord() {

        // Given
        final String input = "aa b";

        // When
        final String result = Kata.high(input);

        // Then
        assertThat(result)
                .isEqualTo("aa");
    }
}
