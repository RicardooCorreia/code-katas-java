package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindCenterOfStarGraphTest {

    private final FindCenterOfStarGraph.Solution subject = new FindCenterOfStarGraph.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {4, 2}}, 2),
                Arguments.of(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findCenter(
            // Given
            int[][] edges,
            int expected) {

        // When
        int result = subject.findCenter(edges);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}