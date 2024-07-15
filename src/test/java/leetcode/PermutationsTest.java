package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationsTest {

    private final Permutations.Solution subject = new Permutations.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(
                        new int[]{1, 2, 3}, List.of(
                                List.of(1, 2, 3),
                                List.of(1, 3, 2),
                                List.of(2, 1, 3),
                                List.of(2, 3, 1),
                                List.of(3, 1, 2),
                                List.of(3, 2, 1)
                        )),
                Arguments.arguments(new int[]{0, 1}, List.of(
                        List.of(1, 0),
                        List.of(0, 1)
                )),
                Arguments.arguments(new int[]{1}, List.of(
                        List.of(1)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void permute(
            // Given
            int[] input,
            List<List<Integer>> expected) {

        // When
        List<List<Integer>> result = subject.permute(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(expected.toArray(new List[0]));
    }
}