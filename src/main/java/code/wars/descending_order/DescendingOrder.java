package code.wars.descending_order;

import java.util.stream.Collectors;

public class DescendingOrder {

    public static int sortDesc(final int num) {

        return Integer.parseInt(String.valueOf(num).chars()
                .mapToObj(value -> value - 48)
                .sorted((o1, o2) -> o2 - o1)
                .map(String::valueOf)
                .collect(Collectors.joining("")));
    }
}
