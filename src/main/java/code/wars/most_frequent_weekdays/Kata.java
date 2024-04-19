package code.wars.most_frequent_weekdays;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {

    private final static List<String> WEEK_DAYS_NAME =
            List.of("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

    private final static Map<String, Integer> WEEK_DAYS_ORDER = Map.of(
            "Monday", 1,
            "Tuesday", 2,
            "Wednesday", 3,
            "Thursday", 4,
            "Friday", 5,
            "Saturday", 6,
            "Sunday", 7
    );

    public static String[] mostFrequentDays(int year) {
        int days = year % 4 == 0 ? 366 : 365;
        return IntStream.rangeClosed(1, days)
                .mapToObj(day -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.DAY_OF_YEAR, day);
                    return calendar.get(Calendar.DAY_OF_WEEK);
                })
                .map(dayOfWeek -> WEEK_DAYS_NAME.get(dayOfWeek - 1))
                .collect(Collectors.groupingBy(dayOfWeek -> dayOfWeek, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toUnmodifiableList())))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(o -> o.getKey().intValue()))
                .map(Map.Entry::getValue)
                .orElse(List.of())
                .stream()
                .sorted(Comparator.comparingInt(WEEK_DAYS_ORDER::get))
                .toArray(String[]::new);
    }
}
