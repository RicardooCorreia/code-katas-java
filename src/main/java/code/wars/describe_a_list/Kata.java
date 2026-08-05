package code.wars.describe_a_list;

import java.util.List;

public class Kata {

    public static String describeList(List<?> list) {

        return switch (list.size()) {
            case 0 -> "empty";
            case 1 -> "singleton";
            default -> "longer";
        };
    }
}
