package code.wars.sum_consecutives;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consecutives {

    public static List<Integer> sumConsecutives(List<Integer> s) {

        if (s.isEmpty()) {
            return List.of();
        }

        var current = s.getFirst();
        int currentCount = 1;
        final List<Integer> result = new ArrayList<>();

        for (int i = 1; i < s.size(); i++) {
            final var next = s.get(i);
            if (Objects.equals(current, next)) {
                currentCount++;
            } else {
                result.add(current * currentCount);
                current = next;
                currentCount = 1;
            }
        }

        result.add(current * currentCount);

        return result;
    }
}
