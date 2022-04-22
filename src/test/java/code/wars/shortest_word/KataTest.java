package code.wars.shortest_word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("bitcoin take over the world maybe who knows perhaps", 3),
                arguments("turns out random test cases are easier than writing out basic ones", 3),
                arguments("Let's travel abroad shall we", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void findShort_baseScenarios(
            // Given
            String input,
            int expected) {

        // When
        final int result = Kata.findShort(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
