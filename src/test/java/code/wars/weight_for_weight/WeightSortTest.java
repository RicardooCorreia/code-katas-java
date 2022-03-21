package code.wars.weight_for_weight;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WeightSortTest {

    public static Stream<Arguments> baseTests() {

        return Stream.of(
                arguments("103 123 4444 99 2000", "2000 103 123 4444 99"),
                arguments("2000 10003 1234000 44444444 9999 11 11 22 123", "11 11 2000 10003 22 123 1234000 44444444 9999")
        );
    }

    @ParameterizedTest
    @MethodSource("baseTests")
    public void orderWeight(
            // Given
            String input,
            String expected) {

        // When
        final String result = WeightSort.orderWeight(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
