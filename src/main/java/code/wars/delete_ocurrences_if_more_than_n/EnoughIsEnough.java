package code.wars.delete_ocurrences_if_more_than_n;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        final Map<Integer, Integer> occurrences = new HashMap<>();
        final ArrayList<Integer> list = new ArrayList<>();
        for (var element : elements) {
            final var elementOccurrences = occurrences.getOrDefault(element, 0) + 1;
            occurrences.put(element, elementOccurrences);
            if (elementOccurrences <= maxOccurrences) {
                list.add(element);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
