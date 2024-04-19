package code.wars.unlucky_days;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class Kata {

    public static int unluckyDays(int year) {

        final Calendar instance = GregorianCalendar.getInstance();
        instance.set(year, Calendar.JANUARY, 13);

        return (int) Stream.generate(() -> {
            final int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);
            instance.add(Calendar.MONTH, 1);
            return dayOfWeek;
        })
                .limit(12)
                .filter(day -> day == 6)
                .count();
    }
}
