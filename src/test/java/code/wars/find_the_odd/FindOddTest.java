package code.wars.find_the_odd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindOddTest {

    public static Stream<Arguments> testCases() {

        return Stream.of(
                arguments(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}, 5),
                arguments(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}, -1),
                arguments(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}, 5),
                arguments(new int[]{10}, 10),
                arguments(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}, 10),
                arguments(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void findIt(
            // Given
            int[] ints,
            int expected) {

        // When
        final int result = FindOdd.findIt(ints);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
