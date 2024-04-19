package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfStudentsUnableToEatLunchTest {

    private final NumberOfStudentsUnableToEatLunch.Solution subject = new NumberOfStudentsUnableToEatLunch.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}, 0),
                Arguments.arguments(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countStudents(
            // Given
            int[] students,
            int[] sandwiches,
            int expected) {

        // When
        int result = subject.countStudents(students, sandwiches);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}