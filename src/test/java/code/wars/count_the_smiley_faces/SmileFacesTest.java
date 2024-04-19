package code.wars.count_the_smiley_faces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SmileFacesTest {

    public static Stream<Arguments> smileys() {

        return Stream.of(
                arguments(List.of(":)", ":D", ":-}", ":-()"), 2),
                arguments(List.of(":)", "XD", ":0}", "x:-", "):-", "D:"), 1),
                arguments(List.of(":)", ":D", "X-}", "xo)", ":X", ":-3", ":3"), 2),
                arguments(List.of(":)", ":)", "x-]", ":ox", ";-(", ";-)", ";~(", ":~D"), 4));
    }

    @ParameterizedTest
    @MethodSource("smileys")
    public void countSmileys(
            // Given
            List<String> input,
            int expected) {

        // When
        final int result = SmileFaces.countSmileys(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("smileys")
    public void countSmileysRegex(
            // Given
            List<String> input,
            int expected) {

        // When
        final int result = SmileFaces.countSmileysRegex(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
