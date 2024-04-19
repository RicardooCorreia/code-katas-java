package code.wars.huma_readable_time;

import java.time.Duration;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {

        final Duration duration = Duration.ofSeconds(seconds);
        return String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }
}
