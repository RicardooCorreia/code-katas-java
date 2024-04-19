package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MakeTheStringGreatTest {

    private final MakeTheStringGreat.Solution subject = new MakeTheStringGreat.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("leEeetcode", "leetcode"),
                Arguments.arguments("abBAcC", ""),
                Arguments.arguments("s", "s")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void makeGood(
            // Given
            String input,
            String expected) {

        // When
        String result = subject.makeGood(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}