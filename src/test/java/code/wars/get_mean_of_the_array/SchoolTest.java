package code.wars.get_mean_of_the_array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SchoolTest {

    public static Stream<Arguments> testCases() {

        return Stream.of(
                arguments(new int[] {2,2,2,2}, 2),
                arguments(new int[] {1,2,3,4,5}, 3),
                arguments(new int[] {1,1,1,1,1,1,1,2}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void getAverage_calculateAverageRoundedToClosestInteger(
            // Given
            int[] grades,
            int expected) {


        // When
        final int result = School.getAverage(grades);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}