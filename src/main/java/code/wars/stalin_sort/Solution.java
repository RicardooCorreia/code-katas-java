package code.wars.stalin_sort;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void stalinSort(List<Integer> arr) {

        if (arr.size() < 2) {
            return;
        }

        Integer previous = arr.getFirst();
        List<Integer> newList = new ArrayList<>(arr.size());
        newList.add(previous);
        for (int i = 1; i < arr.size(); i++) {
            final Integer current = arr.get(i);
            if (previous <= current) {
                newList.add(current);
                previous = current;
            }
        }

        arr.clear();
        arr.addAll(newList);
    }
}
