package code.wars.help_the_bookseller;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StockList {

    private static final String format = "(%s : %s)";

    private record Pair<L, R>(L left, R right) {
    }

    public static String stockSummary(String[] stock, String[] request) {

        if (stock.length == 0 || request.length == 0) {
            return "";
        }

        final Map<String, Integer> availableStock = getAvailableStock(stock);
        return formatRequestedStock(request, availableStock);
    }

    private static String formatRequestedStock(String[] request, Map<String, Integer> availableStock) {
        return Arrays.stream(request)
                .map(requestLetter ->
                        new Pair<>(requestLetter, getStock(requestLetter, availableStock)
                                .orElse(0)))
                .map(pair -> String.format(format, pair.left, pair.right))
                .collect(Collectors.joining(" - "));
    }

    private static Optional<Integer> getStock(String requestLetter, Map<String, Integer> stock) {

        return Optional.ofNullable(stock.get(requestLetter));
    }

    private static Map<String, Integer> getAvailableStock(String[] stock) {

        return Arrays.stream(stock)
                .map(s -> s.split(" "))
                .map(s -> new Pair<>(s[0].substring(0, 1), Integer.valueOf(s[1])))
                .collect(Collectors.groupingBy(pair -> pair.left, Collectors.summingInt(pair -> pair.right)));
    }
}

