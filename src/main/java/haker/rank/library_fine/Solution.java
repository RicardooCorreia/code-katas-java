package haker.rank.library_fine;

import java.io.*;
import java.time.LocalDate;

class Result {

    public static int libraryFine(int returnDay,
                                  int returnMonth,
                                  int returnYear,
                                  int deadlineDay,
                                  int deadlineMonth,
                                  int deadlineYear) {

        final LocalDate returnDate = getDate(returnDay, returnMonth, returnYear);
        final LocalDate deadlineDate = getDate(deadlineDay, deadlineMonth, deadlineYear);

        if (deadlineDate.isBefore(returnDate)) {
            return calculateFine(returnDate, deadlineDate);
        } else {
            return 0;
        }
    }

    private static int calculateFine(LocalDate returnDate, LocalDate deadlineDate) {

        if (deadlineDate.getYear() != returnDate.getYear()) {
            return 10000;
        } else if (deadlineDate.getMonth() != returnDate.getMonth()) {
            return 500 * (returnDate.getMonth().getValue() - deadlineDate.getMonth().getValue());
        } else {
            return 15 * (returnDate.getDayOfMonth() - deadlineDate.getDayOfMonth());
        }
    }

    private static LocalDate getDate(int day, int month, int year) {

        return LocalDate.of(year, month, day);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

