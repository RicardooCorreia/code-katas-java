package code.wars.word_values;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.word_values.Solution.nameValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    static Stream<Arguments> testScenarios() {
        return Stream.of(
                arguments(new String[]{"abc", "abc abc"}, new int[]{6, 24}),
                arguments(new String[]{"codewars", "abc", "xyz"}, new int[]{88, 12, 225}),
                arguments(
                        new String[]{"abcdefghijklmnopqrstuvwxyz", "stamford bridge", "haskellers"},
                        new int[]{351, 282, 330})
        );
    }

    @ParameterizedTest(name = "names={0} -> {1}")
    @MethodSource("testScenarios")
    void computes_name_values(String[] names, int[] expected) {
        var result = nameValue(names);

        assertThat(result).containsExactly(expected);
    }
}