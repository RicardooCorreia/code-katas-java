package code.wars.find_the_parity_outlier;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindOutlierTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new int[]{2, 6, 8, -10, 3}, 3),
                arguments(new int[]{206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781}, 206847684),
                arguments(new int[]{Integer.MAX_VALUE, 0, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void find_baseTests(
            // Given
            int[] input,
            int expected) {

        // When
        final int result = FindOutlier.find(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
