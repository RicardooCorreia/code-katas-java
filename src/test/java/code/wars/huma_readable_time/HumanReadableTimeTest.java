package code.wars.huma_readable_time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HumanReadableTimeTest {

    public static Stream<Arguments> testCases() {

        return Stream.of(
                arguments(0, "00:00:00"),
                arguments(5, "00:00:05"),
                arguments(60, "00:01:00"),
                arguments(86399, "23:59:59"),
                arguments(359999, "99:59:59")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void makeReadable(
            // Given
            int seconds,
            String expected) {

        // When
        final String makeReadable = HumanReadableTime.makeReadable(seconds);

        // Then
        assertThat(makeReadable)
                .isEqualTo(expected);
    }
}