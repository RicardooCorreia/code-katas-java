package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RelativeRankTest {

    private final RelativeRank.Solution subject = new RelativeRank.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{5, 4, 3, 2, 1}, new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}),
                Arguments.arguments(new int[]{10, 3, 8, 9, 4}, new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"})
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findRelativeRanks(
            // Given
            int[] input,
            String[] expected) {

        // When
        String[] result = subject.findRelativeRanks(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}