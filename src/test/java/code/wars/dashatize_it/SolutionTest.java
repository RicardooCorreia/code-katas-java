package code.wars.dashatize_it;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> baseTests() {

        return Stream.of(
                arguments(274, "2-7-4"),
                arguments(5311, "5-3-1-1"),
                arguments(86320, "86-3-20"),
                arguments(974302, "9-7-4-3-02"),
                arguments(0, "0"),
                arguments(-1, "1"),
                arguments(-28369, "28-3-6-9"),
                arguments(Integer.MAX_VALUE, "2-1-4-7-48-3-64-7"),
                arguments(Integer.MIN_VALUE, "2-1-4-7-48-3-648"),
                arguments(-1111111111, "1-1-1-1-1-1-1-1-1-1"));
    }

    @ParameterizedTest
    @MethodSource("baseTests")
    public void testBasic(
            // Given
            int input,
            String expected) {

        // When
        String result = Solution.dashatize(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
