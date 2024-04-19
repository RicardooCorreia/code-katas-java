package code.wars.sum_of_odd_numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RowSumOddNumbersTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1, 1),
                arguments(2, 8),
                arguments(3, 27),
                arguments(4, 64),
                arguments(5, 127),
                arguments(42, 74088)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void rowSumOddNumbers_baseScenarios(
            // Given
            int input,
            int expected) {

        // When
        int result = RowSumOddNumbers.rowSumOddNumbers(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
