package code.wars.digital_root;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DRootTest {

    public static Stream<Arguments> source() {

        return Stream.of(
                arguments(16, 7),
                arguments(456, 6),
                arguments(0, 0),
                arguments(1, 1),
                arguments(100, 1),
                arguments(12345, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void digital_root_thenCalculateCorrectNumber(
            // Given
            int input,
            int expected
    ) {

        // When
        final int result = DRoot.digital_root(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}