package code.wars.isograms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IsogramTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("Dermatoglyphics", true),
                arguments("isogram", true),
                arguments("moose", false),
                arguments("isIsogram", false),
                arguments("aba", false),
                arguments("moOse", false),
                arguments("thumbscrewjapingly", true),
                arguments("", true)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void isIsogram_baseScenarios(
            // Given
            String input,
            boolean expected) {

        // When
        final boolean result = Isogram.isIsogram(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
