package code.wars.ordered_count_of_characters;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> examples() {

        return Stream.of(
            arguments(
                "abracadabra",
                List.of(Pair.of('a', 5), Pair.of('b', 2), Pair.of('r', 2), Pair.of('c', 1), Pair.of('d', 1))),
                arguments(
                        "Code Wars",
                        List.of(
                                Pair.of('C', 1),
                                Pair.of('o', 1),
                                Pair.of('d', 1),
                                Pair.of('e', 1),
                                Pair.of(' ', 1),
                                Pair.of('W', 1),
                                Pair.of('a', 1),
                                Pair.of('r', 1),
                                Pair.of('s', 1))),
                arguments(
                        "233312",
                        List.of(Pair.of('2', 2), Pair.of('3', 3), Pair.of('1', 1)))
        );
    }

    @ParameterizedTest(name = "[{index}]")
    @MethodSource("examples")
    void orderedCount(
            // Given
            String text,
            List<Pair<Character, Integer>> expected) {

        // When
        var result = Solution.orderedCount(text);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
