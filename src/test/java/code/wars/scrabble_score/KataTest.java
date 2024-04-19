package code.wars.scrabble_score;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("", 0),
                arguments("a", 1),
                arguments("f", 4),
                arguments("street", 6),
                arguments(" a", 1),
                arguments("st re et", 6),
                arguments("quirky", 22),
                arguments("MULTIBILLIONAIRE", 20),
                arguments("alacrity", 13),
                arguments("STREET", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void scrabbleScore_baseTests(
            // Given
            String input,
            int expected) {

        // When
        final int result = Kata.scrabbleScore(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
