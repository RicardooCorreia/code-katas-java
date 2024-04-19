package code.wars.string_ends_with;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("samurai", "ai", true),
                arguments("sumo", "omo", false),
                arguments("ninja", "ja", true),
                arguments("sensei", "i", true),
                arguments("samurai", "ra", false),
                arguments("abc", "abcd", false),
                arguments("abc", "abc", true),
                arguments("abcabc", "bc", true),
                arguments("ails", "fails", false),
                arguments("fails", "ails", true),
                arguments("this", "fails", false),
                arguments("this", "", true),
                arguments(":-)", ":-(", false),
                arguments("!@#$%^&*() :-)", ":-)", true),
                arguments("abc\n", "abc", false)
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void staticTests(
            // Given
            String string,
            String ending,
            boolean expected) {

        // When
        boolean result = Kata.solution(string, ending);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
