package haker.rank.day_of_the_programmer;

import java.io.*;
import java.time.Year;

class Result {

    private static final int PROGRAMMER_DAY_MONTH = 9;

    private static final int CHANGE_YEAR = 1918;

    private static final int PROGRAMMER_DAY_IN_LEAP_YEAR = 12;

    private static final int PROGRAMMER_DAY_IN_NOT_LEAP_YEAR = 13;

    private static final int PROGRAMMER_DAY_IN_CHANGE_YEAR = 26;

    private static final String DATE_FORMAT = "%02d.%02d.%04d";

    public static String dayOfProgrammer(int year) {

        if (year == CHANGE_YEAR) {
            return formatDate(PROGRAMMER_DAY_IN_CHANGE_YEAR, PROGRAMMER_DAY_MONTH, CHANGE_YEAR);
        }

        if (isLeapYear(year)) {
            return formatDate(PROGRAMMER_DAY_IN_LEAP_YEAR, PROGRAMMER_DAY_MONTH, year);
        }
        return formatDate(PROGRAMMER_DAY_IN_NOT_LEAP_YEAR, PROGRAMMER_DAY_MONTH, year);
    }

    private static boolean isLeapYear(int year) {

        if (year >= CHANGE_YEAR) {
            return Year.of(year).isLeap();
        } else {
            return year % 4 == 0;
        }
    }

    private static String formatDate(int day, int month, int year) {

        return String.format(DATE_FORMAT, day, month, year);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

