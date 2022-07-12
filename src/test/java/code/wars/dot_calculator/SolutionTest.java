package code.wars.dot_calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("..... // .", "....."),
                arguments("..... * ..", ".........."),
                arguments("..... // ..", ".."),
                arguments("..... - .", "...."),
                arguments("..... + ...............", "...................."),
                arguments("..... * ...", "..............."),
                arguments("..... - ...", ".."),
                arguments(". - .", ""),
                arguments(". // ..", "")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void calc_baseTests(
            // Given
            String input,
            String expected) {

        // When
        final String result = Solution.calc(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
