package code.wars.multiplication_table;

public class Mult {

    public static String table(int row, int column) {

        final StringBuilder tableBuilder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tableBuilder.append(lastDigitOfMultiplication(i, j));
            }
            tableBuilder.append("\n");
        }

        return tableBuilder.toString().trim();
    }

    private static int lastDigitOfMultiplication(int i, int j) {
        final String number = String.valueOf((i + 1) * (j + 1));
        return number.charAt(number.length() - 1) - 48;
    }
}
