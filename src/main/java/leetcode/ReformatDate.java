package leetcode;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.

Example 1:
    Input: date = "20th Oct 2052"
    Output: "2052-10-20"
Example 2:
    Input: date = "6th Jun 1933"
    Output: "1933-06-06"
Example 3:
    Input: date = "26th May 1960"
    Output: "1960-05-26"

Constraints:
    The given dates are guaranteed to be valid, so no error handling is necessary.
 */
public class ReformatDate {

    static class Solution {

        private static final List<String> MONTHS = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec");

        private static final String INPUT_DATE_REGEX = "(?<day>.{1,2})\\D\\D (?<month>.{3}) (?<year>.*)";

        public String reformatDate(String date) {

            Pattern pattern = Pattern.compile(INPUT_DATE_REGEX);
            Matcher matcher = pattern.matcher(date);

            if (matcher.find()) {
                int day = Integer.parseInt(matcher.group("day"));
                int month = MONTHS.indexOf(matcher.group("month")) + 1;
                String year = matcher.group("year");

                return String.join("-", year, formatDateNumber(month), formatDateNumber(day));
            }

            throw new IllegalArgumentException("Regex didn't match");
        }

        private static String formatDateNumber(int month) {
            return String.format("%02d", month);
        }
    }
}
