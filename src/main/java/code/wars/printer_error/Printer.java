package code.wars.printer_error;

public class Printer {

    public static String printerError(String s) {

        final long errors = s.chars()
                .filter(c -> c < 'a' || c > 'm')
                .count();

        return String.format("%s/%s", errors, s.length());
    }
}
