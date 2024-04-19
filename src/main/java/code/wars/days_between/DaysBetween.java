package code.wars.days_between;

import java.time.LocalDate;
import java.time.Period;

public class DaysBetween {

    public static long getDaysAlive(int year, int month, int day, int year2, int month2, int day2) {

        LocalDate firstDate = LocalDate.of(year, month, day);
        LocalDate secondDate = LocalDate.of(year2, month2, day2);

        return firstDate.datesUntil(secondDate, Period.ofDays(1))
                .count();
    }
}
