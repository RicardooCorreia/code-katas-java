package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheHighestAltitudeTest {

    private final FindTheHighestAltitude.Solution subject = new FindTheHighestAltitude.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{-5, 1, 5, 0, -7}, 1),
                Arguments.arguments(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void largestAltitude(
            // Given
            int[] gain,
            int expected) {

        // When
        int result = subject.largestAltitude(gain);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}

