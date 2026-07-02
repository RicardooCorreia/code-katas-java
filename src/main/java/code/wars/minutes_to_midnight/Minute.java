package code.wars.minutes_to_midnight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.ZoneId.systemDefault;

public class Minute {

    public String countMinutes(Date d) {

        final var date = LocalDateTime.ofInstant(d.toInstant(), systemDefault());
        final var midnight = date.toLocalDate().plusDays(1).atStartOfDay();
        final var secondsToMidnight = Duration.between(date, midnight).getSeconds();
        final var minutes = secondsToMidnight / 60;

        return minutes + (minutes == 1 ? " minute" : " minutes");
    }
}