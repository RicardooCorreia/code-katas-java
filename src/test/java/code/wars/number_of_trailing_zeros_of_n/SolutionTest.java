package code.wars.number_of_trailing_zeros_of_n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> factorials() {

        return Stream.of(
                arguments(0, 0),
                arguments(6, 1),
                arguments(14, 2),
                arguments(15, 3),
                arguments(27, 6),
                arguments(2892, 720),
                arguments(124532, 31129)
        );
    }

    @ParameterizedTest
    @MethodSource("factorials")
    void testZeros() {

        // Given
        final int input = 0;

        // When
        final int result = Solution.zeros(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}