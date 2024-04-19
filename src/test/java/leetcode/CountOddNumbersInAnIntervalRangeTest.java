package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountOddNumbersInAnIntervalRangeTest {

    private final CountOddNumbersInAnIntervalRange.Solution subject = new CountOddNumbersInAnIntervalRange.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(3, 7, 3),
                Arguments.arguments(8, 10, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countOdds(
            // Given
            int low,
            int high,
            int expected) {

        // When
        int result = subject.countOdds(low, high);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}