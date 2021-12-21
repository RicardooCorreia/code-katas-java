package haker.rank.cut_the_sticks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class ResultTest {

    public static Stream<Arguments> sticksWithExpectedResult() {

        return Stream.of(
                arguments(List.of(5, 4, 4, 2, 2, 8), List.of(6, 4, 2, 1)),
                arguments(List.of(1, 2, 3, 4, 3, 3, 2, 1), List.of(8, 6, 4, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("sticksWithExpectedResult")
    void cutTheSticks_whenTheresMultipleIterations_returnCorrectValue(
            // Given
            List<Integer> sticks,
            List<Integer> expectedCount) {

        // When
        final List<Integer> result = Result.cutTheSticks(sticks);

        // Then
        assertThat(result)
                .isEqualTo(expectedCount);
    }
}