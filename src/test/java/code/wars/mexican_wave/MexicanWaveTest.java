package code.wars.mexican_wave;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MexicanWaveTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("hello", new String[]{"Hello", "hEllo", "heLlo", "helLo", "hellO"}),
                arguments("codewars", new String[]{"Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS"})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void wave_whenNormalFlow_returnWave(
            // Given
            String input,
            String[] expected) {

        // When
        final String[] result = MexicanWave.wave(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void wave_whenEmpty_returnsEmpty() {

        // Given
        final String input = "";

        // When
        final String[] result = MexicanWave.wave(input);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void wave_whenTwoWords_returnsCorrectWave() {

        // Given
        final String input = "two words";

        // When
        final String[] result = MexicanWave.wave(input);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS"});
    }

    @Test
    void wave_whenHasGap_returnsCorrectWave() {

        // Given
        final String input = " gap ";

        // When
        final String[] result = MexicanWave.wave(input);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{" Gap ", " gAp ", " gaP "});
    }
}
