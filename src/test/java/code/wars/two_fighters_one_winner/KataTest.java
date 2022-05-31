package code.wars.two_fighters_one_winner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.two_fighters_one_winner.Kata.Fighter;
import static code.wars.two_fighters_one_winner.Kata.declareWinner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew", "Lew"),
                arguments(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Harry", "Harry"),
                arguments(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry", "Harald"),
                arguments(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald", "Harald"),
                arguments(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry", "Harald"),
                arguments(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald", "Harald")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void declareWinner_baseTests(
            // Given
            Fighter fighter1,
            Fighter fighter2,
            String firstAttacker,
            String expected) {

        // When
        final String result = declareWinner(fighter1, fighter2, firstAttacker);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
