package code.wars.wheres_my_parent;

import java.util.stream.Collectors;

class WhereIsMyParent {

    static String findChildren(final String text) {

        return text.chars()
                .mapToObj(value -> (char) value)
                .sorted((o1, o2) -> {
                    final Character lowerCase1 = Character.toLowerCase(o1);
                    final Character lowerCase2 = Character.toLowerCase(o2);
                    final int compare = lowerCase1.compareTo(lowerCase2);
                    return compare == 0 ? o1.compareTo(o2) : compare;
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
