package code.wars.persistent_burger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PersistTest {

    public static Stream<Arguments> testScenarios() {

        return Stream.of(
                arguments(39, 3),
                arguments(4, 0),
                arguments(25, 2),
                arguments(999, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testScenarios")
    void persistence_baseTests(
            // Given
            int input,
            int expected) {

        // When
        final int result = Persist.persistence(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
