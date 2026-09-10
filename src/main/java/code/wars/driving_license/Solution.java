package code.wars.driving_license;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Locale.ENGLISH;

public class Solution {

    public static String driver(String[] data) {

        final var firstName = data[0];
        final var middleName = data[1];
        final var surname = data[2];
        final var birthdate = parseBirthdate(data[3]);
        final var isFemale = "F".equals(data[4]);

        final var surnamePart = (surname + "99999").substring(0, 5).toUpperCase();
        final var year = birthdate.getYear();
        final var decadeDigit = (year / 10) % 10;
        final var month = birthdate.getMonthValue() + (isFemale ? 50 : 0);
        final var day = birthdate.getDayOfMonth();
        final var yearDigit = year % 10;
        final var middleInitial = middleName.isEmpty() ? "9" : middleName.substring(0, 1).toUpperCase();

        return surnamePart
            + decadeDigit
            + String.format("%02d", month)
            + String.format("%02d", day)
            + yearDigit
            + firstName.substring(0, 1).toUpperCase()
            + middleInitial
            + "9AA";
    }

    private static LocalDate parseBirthdate(String date) {
        final var abbreviatedMonth = DateTimeFormatter.ofPattern("dd-MMM-yyyy", ENGLISH);
        final var fullMonth = DateTimeFormatter.ofPattern("dd-MMMM-yyyy", ENGLISH);

        return date.matches("\\d{2}-[A-Za-z]{3}-\\d{4}")
               ? LocalDate.parse(date, abbreviatedMonth)
               : LocalDate.parse(date, fullMonth);
    }
}
