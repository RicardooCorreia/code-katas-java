package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRangesTest {

    private final SummaryRanges.Solution subject = new SummaryRanges.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.arguments(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9"))
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void summaryRanges(
        // Given
            int[] input,
            List<String> expected) {

        // When
        List<String> result = subject.summaryRanges(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}