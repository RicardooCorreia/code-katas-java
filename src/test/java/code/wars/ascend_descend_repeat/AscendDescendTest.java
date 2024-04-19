package code.wars.ascend_descend_repeat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AscendDescendTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(5, 1, 3, "12321"),
                arguments(14, 0, 2, "01210121012101"),
                arguments(11, 5, 9, "56789876567")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void ascendDescend_baseTests(
            // Given
            int length,
            int min,
            int max,
            String expected) {

        // When
        final String result = AscendDescend.ascendDescend(length, min, max);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
