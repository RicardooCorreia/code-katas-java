package code.wars.sum_digit_power;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumDigPowerTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1, 10, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                arguments(1, 100, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 89}),
                arguments(10, 100, new long[]{89}),
                arguments(90, 100, new long[]{}),
                arguments(90, 150, new long[]{135}),
                arguments(50, 150, new long[]{89, 135}),
                arguments(10, 150, new long[]{89, 135})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void sumDigPow_baseTests(
            // Given
            int startRange,
            int endRange,
            long[] expected
    ) {

        // When
        final List<Long> result = SumDigPower.sumDigPow(startRange, endRange);

        // Then
        assertThat(result)
                .isEqualTo(Arrays.stream(expected).boxed().toList());
    }
}
