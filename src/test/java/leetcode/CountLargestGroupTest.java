package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountLargestGroupTest {

    private final CountLargestGroup.Solution subject = new CountLargestGroup.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(13, 4),
                Arguments.arguments(2, 2),
                Arguments.arguments(15, 6),
                Arguments.arguments(24, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countLargestGroup(
            // Given
            int n,
            int expected) {

        // When
        int result = subject.countLargestGroup(n);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}