package code.wars.greet_me;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GreetMeTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("riley", "Hello Riley!"),
                arguments("JACK", "Hello Jack!"),
                arguments("   BuZiO    ", "Hello Buzio!")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void greet(
            // Given
            String input,
            String expected) {

        // When
        final String result = GreetMe.greet(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
