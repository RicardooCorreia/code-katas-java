package code.wars.my_friend_time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TimeWhereverIgoTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("27-03-2021 19:41", "Europe/Warsaw", "Africa/Asmera", "27-03-2021 21:41"),
                arguments("27-03-2021 19:41", "Europe/Warsaw", "Australia/Sydney", "28-03-2021 05:41"),
                arguments("28-03-2021 19:41", "Australia/Sydney", "Europe/Warsaw", "28-03-2021 10:41"),
                arguments("19-03-2021 01:01", "America/Halifax", "Asia/Makassar", "19-03-2021 12:01"),
                arguments("01-12-2021 00:00", "Europe/Dublin", "Europe/Belfast", "01-12-2021 00:00"),
                arguments("07-12-2021 23:59", "Pacific/Fiji", "Europe/Berlin", "07-12-2021 11:59"));
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void getFriendDateAndTime_baseScenarios(
            // Given
            String initialTime,
            String initialTimeZone,
            String finalTimeZone,
            String expected) {

        // When
        final String result = TimeWhereverIgo.getFriendDateAndTime(initialTime, initialTimeZone, finalTimeZone);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
