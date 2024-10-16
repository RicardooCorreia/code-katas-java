package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KidsWithTheGreatestNumberOfCandiesTest {

    private final KidsWithTheGreatestNumberOfCandies.Solution subject = new KidsWithTheGreatestNumberOfCandies.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(List.of(2, 3, 5, 1, 3), 3, List.of(true, true, true, false, true)),
                Arguments.arguments(List.of(4, 2, 1, 1, 2), 1, List.of(true, false, false, false, false)),
                Arguments.arguments(List.of(12, 1, 12), 10, List.of(true, false, true))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void kidsWithCandies(
            // Given
            List<Integer> candies,
            int extraCandies,
            List<Boolean> expected
    ) {

        // When
        List<Boolean> result = subject.kidsWithCandies(candies.stream().mapToInt(i -> i).toArray(), extraCandies);

        // Then
        assertThat(result)
                .isEqualTo(expected);

    }
}