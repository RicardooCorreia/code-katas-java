package code.wars.remove_the_minimum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoverTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3, 4, 5}),
                arguments(new int[]{5, 3, 2, 1, 4}, new int[]{5, 3, 2, 4}),
                arguments(new int[]{2, 2, 1, 2, 1}, new int[]{2, 2, 2, 1}),
                arguments(new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void removeSmallest_baseTests(
            // Given
            int[] input,
            int[] expected) {

        // When
        final int[] result = Remover.removeSmallest(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
