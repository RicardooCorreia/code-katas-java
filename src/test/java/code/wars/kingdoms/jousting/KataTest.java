package code.wars.kingdoms.jousting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                Arguments.arguments(
                        new String[]{"$->    ", "    <-P"},
                        new String[]{" $->   ", "   <-P "}),
                Arguments.arguments(
                        new String[]{"$->     ", "     <-P"},
                        new String[]{"  $->   ", "   <-P  "}),
                Arguments.arguments(
                        new String[]{"$->              ", "              <-P"},
                        new String[]{"      $->        ", "        <-P      "})
        );
    }

    public static Stream<Arguments> differentVelocities() {

        return Stream.of(
                Arguments.arguments(
                        new String[]{"$->    ", "    <-P"},
                        new String[]{"   $-> ", " <-P   "},
                        3, 3),
                Arguments.arguments(
                        new String[]{"$->     ", "     <-P"},
                        new String[]{"$->     ", " <-P    "},
                        0, 2),
                Arguments.arguments(
                        new String[]{"$->              ", "              <-P"},
                        new String[]{"      $->        ", "     <-P         "},
                        2, 3)
        );
    }

    public static Stream<Arguments> immediateBattles() {

        return Stream.of(
                Arguments.arguments(new String[]{"$->  ", "  <-P"}, 3, 3),
                Arguments.arguments(new String[]{"$->", "<-P"}, 3, 3),
                Arguments.arguments(new String[]{"$-> ", " <-P"}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void joust_whenHasSameVelocity_returnEndPositions(
            // Given
            String[] input,
            String[] expected) {

        // When
        String[] result = Kata.joust(input, 1, 1);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("differentVelocities")
    void joust_whenDifferentVelocities_returnEndPositions(
            // Given
            String[] input,
            String[] expected,
            int leftKnightVelocity,
            int rightKnightVelocity
    ) {

        // When
        String[] result = Kata.joust(input, leftKnightVelocity, rightKnightVelocity);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("immediateBattles")
    void joust_whenImmediateBatter_returnSamePositions(
            // Given
            String[] field,
            int velocityLeft,
            int velocityRight
    ) {

        // When
        String[] result = Kata.joust(field, velocityLeft, velocityRight);

        // Then
        assertThat(result)
                .isEqualTo(field);
    }

    @Test
    void joust_whenRefuseToBattle_returnSame() {

        // Given
        String[] input = {
                "$->    ",
                "    <-P"
        };
        int velocity = 0;

        // When
        String[] result = Kata.joust(input, velocity, velocity);

        // Then
        assertThat(result)
                .isEqualTo(input);
    }
}

