package code.wars.easy_balance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/*
https://www.codewars.com/kata/59d727d40e8c9dd2dd00009f/train/java
You are given a (small) check book as a - sometimes - cluttered (by non-alphanumeric characters) string:

"1000.00
125 Market 125.45
126 Hardware 34.95
127 Video 7.45
128 Book 14.32
129 Gasoline 16.10"
The first line shows the original balance. Each other line (when not blank) gives information: check number, category, check amount. (Input form may change depending on the language).

First you have to clean the lines keeping only letters, digits, dots and spaces.

Then return a report as a string (underscores show spaces -- don't put them in your solution. They are there so you can see them and how many of them you need to have):

"Original_Balance:_1000.00
125_Market_125.45_Balance_874.55
126_Hardware_34.95_Balance_839.60
127_Video_7.45_Balance_832.15
128_Book_14.32_Balance_817.83
129_Gasoline_16.10_Balance_801.73
Total_expense__198.27
Average_expense__39.65"
On each line of the report you have to add the new balance and then in the last two lines the total expense and the average expense. So as not to have a too long result string we don't ask for a properly formatted result.

Notes
See input examples in Sample Tests.
It may happen that one (or more) line(s) is (are) blank.
Round to 2 decimals your calculated results (Elm: without traling 0)
The line separator of results may depend on the language \n or \r\n. See examples in the "Sample tests".
R language: Don't use R's base function "mean()" that could give results slightly different from expected ones.
 */
public class EasyBal {

    public static final String NEW_LINE = "\\r\\n";

    public static String balance(String book) {

        String[] lines = book.split("\n");

        StringBuilder result = new StringBuilder();

        String balance = cleanUpString(lines[0]);
        double startingBalance = Double.parseDouble(balance);

        result
                .append("Original Balance: ")
                .append(formatNumber(startingBalance))
                .append(NEW_LINE);

        AtomicReference<Double> totalExpense = new AtomicReference<>(0.0);
        List<Double> values = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            Transaction.parse(line)
                    .ifPresent(transaction -> {
                        double amount = transaction.amount();
                        Double runningExpense = totalExpense.updateAndGet(value -> (value + amount));
                        values.add(amount);

                        result
                                .append(transaction.checkNumber())
                                .append(" ")
                                .append(transaction.category())
                                .append(" ")
                                .append(formatNumber(amount))
                                .append(" Balance ")
                                .append(formatNumber(startingBalance - runningExpense))
                                .append(NEW_LINE);
                    });
        }

        result
                .append("Total expense  ")
                .append(formatNumber(totalExpense.get()))
                .append(NEW_LINE)
                .append("Average expense  ")
                .append(formatNumber(values.stream().mapToDouble(value -> value).average().getAsDouble()));

        return result.toString();
    }

    private static String cleanUpString(String line) {
        return line
                .replaceAll("[^a-zA-Z0-9. ]", "")
                .replaceAll(" +", " ");
    }

    private static String formatNumber(Double number) {
        return String.format("%.2f", number);
    }

    private record Transaction(String checkNumber, String category, double amount) {

        private static Optional<Transaction> parse(String string) {
            String cleanedString = cleanUpString(string);
            if (cleanedString.isBlank()) {
                return Optional.empty();
            }
            String[] parts = cleanedString.split(" ");

            String checkNumber = parts[0];
            String category = parts[1];
            double amount = Double.parseDouble(parts[2]);

            return Optional.of(new Transaction(checkNumber, category, amount));
        }
    }
}
