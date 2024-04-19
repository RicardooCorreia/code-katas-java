package code.wars.human_readable_duration_format;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    public static String formatDuration(int totalSeconds) {

        if (totalSeconds < 1) {
            return "now";
        }

        Duration duration = Duration.ofSeconds(totalSeconds);

        StringBuilder result = new StringBuilder();
        long days = duration.toDaysPart();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        long years = days / 365;
        days = days - (years * 365);

        List<TimeDuration> times = new ArrayList<>();

        addToStackIfNotEmpty(years, times, ChronoUnit.YEARS);
        addToStackIfNotEmpty(days, times, ChronoUnit.DAYS);
        addToStackIfNotEmpty(hours, times, ChronoUnit.HOURS);
        addToStackIfNotEmpty(minutes, times, ChronoUnit.MINUTES);
        addToStackIfNotEmpty(seconds, times, ChronoUnit.SECONDS);

        for (int i = 0; i < times.size() - 1; i++) {

            if (!result.isEmpty()) {
                result.append(", ");
            }
            TimeDuration timeDuration = times.get(i);
            result.append(timeDuration.amount())
                    .append(" ")
                    .append(parseUnit(timeDuration.amount(), timeDuration));
        }

        if (!result.isEmpty()) {
            result.append(" and ");
        }

        TimeDuration timeDuration = times.get(times.size() - 1);
        result.append(timeDuration.amount())
                .append(" ")
                .append(parseUnit(timeDuration.amount(), timeDuration));

        return result.toString();
    }

    private static String parseUnit(long amount, TimeDuration timeDuration) {

        String pluralUnits = timeDuration.unit().toString().toLowerCase();
        if (amount > 1) {
            return pluralUnits;
        } else {
            return pluralUnits.substring(0, pluralUnits.length() - 1);
        }
    }

    private static void addToStackIfNotEmpty(long minutes, List<TimeDuration> times, ChronoUnit minutes1) {

        if (minutes > 0) {
            times.add(new TimeDuration(minutes, minutes1));
        }
    }

    private record TimeDuration(long amount, TemporalUnit unit) {

    }
}
