package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GoalParserInterpretationTest {

    private final GoalParserInterpretation.Solution subject = new GoalParserInterpretation.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments("G()(al)", "Goal"),
                Arguments.arguments("G()()()()(al)", "Gooooal"),
                Arguments.arguments("(al)G(al)()()G", "alGalooG"));
    }

    @ParameterizedTest
    @MethodSource("examples")
    void interpret(
            // Given
            String command,
            String expected) {

        // When
        String result = subject.interpret(command);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}