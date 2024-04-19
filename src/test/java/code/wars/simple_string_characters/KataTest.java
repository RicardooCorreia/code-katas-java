package code.wars.simple_string_characters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("Codewars@codewars123.com", new int[]{1, 18, 3, 2}),
                arguments("CbgA5<1d-tOwUZTS8yQ", new int[]{8, 6, 3, 2}),
                arguments("P*K4%>mQUDaG$h=cx2?.Czt7!Zn16p@5H", new int[]{9, 9, 6, 9}),
                arguments("RYT'>s&gO-.CM9AKeH?,5317tWGpS<*x2ukXZD", new int[]{15, 8, 6, 9}),
                arguments("$Cnl)Sr<7bBW-&qLHI!mY41ODe", new int[]{10, 7, 3, 6}),
                arguments("@mw>0=QD-iAx!rp9TaG?o&M%l$34L.nbft", new int[]{7, 13, 4, 10}));
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void solve_baseTests(
            // Given
            String input,
            int[] expected) {

        // When
        final int[] result = Kata.solve(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
