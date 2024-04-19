package code.wars.list_filtering;

import java.util.List;
import java.util.stream.Collectors;

public class Kata {

    public static List<Object> filterList(final List<Object> list) {

        return list.stream()
                .filter(element -> element instanceof Integer)
                .map(element -> (int) element)
                .filter(integer -> integer >= 0)
                .collect(Collectors.toUnmodifiableList());
    }
}
