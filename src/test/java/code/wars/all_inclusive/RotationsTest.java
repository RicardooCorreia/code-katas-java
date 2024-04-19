package code.wars.all_inclusive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RotationsTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("", List.of(), true),
                arguments("", List.of("bsjq", "qbsj"), true),
                arguments("bsjq", List.of("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs"), true),
                arguments("XjYABhR", List.of("TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void test(
            // Given
            String string,
            List<String> rotations,
            boolean expected) {

        // When
        final boolean result = Rotations.containAllRots(string, rotations);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
