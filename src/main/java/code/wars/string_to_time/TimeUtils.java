package code.wars.string_to_time;

import java.time.Duration;

class TimeUtils {
    public static String convertTime(int timeDiff) {

        Duration duration = Duration.ofSeconds(timeDiff);
        return String.join(" ",
                           String.valueOf(duration.toDaysPart()),
                           String.valueOf(duration.toHoursPart()),
                           String.valueOf(duration.toMinutesPart()),
                           String.valueOf(duration.toSecondsPart()));
    }
}
