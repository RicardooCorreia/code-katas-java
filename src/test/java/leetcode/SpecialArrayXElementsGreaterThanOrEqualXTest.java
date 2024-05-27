package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialArrayXElementsGreaterThanOrEqualXTest {

    private final SpecialArrayXElementsGreaterThanOrEqualX.Solution subject
            = new SpecialArrayXElementsGreaterThanOrEqualX.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{3, 5}, 2),
                Arguments.arguments(new int[]{0, 0}, -1),
                Arguments.arguments(new int[]{0, 4, 3, 0, 4}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void specialArray(
            // Given
            int[] input, int expected) {

        // When
        int result = subject.specialArray(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}