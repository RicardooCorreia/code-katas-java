package code.wars.unique_string_characters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("xyab", "xzca", "ybzc"),
                arguments("xyabb", "xzca", "ybbzc"),
                arguments("abcd", "xyz", "abcdxyz"),
                arguments("xxx", "xzca", "zca")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void solve_baseTests(
            // Given
            String input1,
            String input2,
            String expected) {

        // When
        String result = Solution.solve(input1, input2);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
