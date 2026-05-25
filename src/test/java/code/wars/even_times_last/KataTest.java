package code.wars.even_times_last;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.even_times_last.Kata.evenLast;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> basicTests() {

        return Stream.of(
            Arguments.of(new int[]{2, 3, 4, 5}, 30),
            Arguments.of(new int[]{}, 0),
            Arguments.of(new int[]{2, 2, 2, 2}, 8),
            Arguments.of(new int[]{1, 3, 3, 1, 10}, 140),
            Arguments.of(new int[]{-11, 3, 3, 1, 10}, 20)
        );
    }

    @ParameterizedTest(name = "[{index}]")
    @MethodSource("basicTests")
    public void testSampleCases(
        // Given
        int[] numbers,
        int expected) {

        // When
        var result = evenLast(numbers);

        // Then
        assertThat(result)
            .isEqualTo(expected);
    }
}