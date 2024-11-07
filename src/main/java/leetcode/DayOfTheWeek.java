package leetcode;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;

public class DayOfTheWeek {

    static class Solution {

        private static final Map<Integer, String> DAY_OF_WEEK_NAMES = Map.of(
                Calendar.SUNDAY, "Sunday",
                Calendar.MONDAY, "Monday",
                Calendar.TUESDAY, "Tuesday",
                Calendar.WEDNESDAY, "Wednesday",
                Calendar.THURSDAY, "Thursday",
                Calendar.FRIDAY, "Friday",
                Calendar.SATURDAY, "Saturday"
        );

        public String dayOfTheWeek(int day, int month, int year) {

            TimeZone timezone = TimeZone.getDefault();
            GregorianCalendar calendar = new GregorianCalendar(timezone);
            calendar.set(year, month - 1, day);
            return DAY_OF_WEEK_NAMES.get(calendar.get(Calendar.DAY_OF_WEEK));
        }
    }
}
