package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheDuplicateNumberTest {

    private final FindTheDuplicateNumber.Solution subject = new FindTheDuplicateNumber.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 3, 4, 2, 2}, 2),
                Arguments.arguments(new int[]{3, 1, 3, 4, 2}, 3),
                Arguments.arguments(new int[]{3, 3, 3, 3, 3}, 3),
                Arguments.arguments(new int[]{4, 3, 1, 4, 2}, 4)
                );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void findDuplicate(
            // Given
            int[] input,
            int expected) {

        // When
        int result = subject.findDuplicate(input);
        int result2 = subject.findDuplicateHigherTimeComplexity(input);
        int result3 = subject.findDuplicateLowerTimeComplexity(input);

        // Then
        assertThat(result)
                .isEqualTo(expected)
                .isEqualTo(result2)
                .isEqualTo(result3);
    }
}