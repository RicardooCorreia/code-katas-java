package code.wars.see_you_next_happy_year;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HappyYearTest {

    public static Stream<Arguments> largeValues() {

        return Stream.of(
                arguments(5555, 5601),
                arguments(7712, 7801),
                arguments(8088, 8091),
                arguments(8800, 8901),
                arguments(8989, 9012),
                arguments(8977, 9012),
                arguments(6869, 6870),
                arguments(8999, 9012)
        );
    }

    public static Stream<Arguments> basicValues() {

        return Stream.of(
                arguments(1001, 1023),
                arguments(1123, 1203),
                arguments(2001, 2013),
                arguments(2334, 2340),
                arguments(3331, 3401),
                arguments(2342, 2345),
                arguments(1987, 2013),
                arguments(2013, 2014),
                arguments(3000, 3012)
        );
    }

    @ParameterizedTest
    @MethodSource("basicValues")
    public void Check_Basic_Values(
            // Given
            int input,
            int expected) {

        // When
        final int result = HappyYear.nextHappyYear(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("largeValues")
    public void Check_Larger_Values(
            // Given
            int input,
            int expected) {

        // When
        final int result = HappyYear.nextHappyYear(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
