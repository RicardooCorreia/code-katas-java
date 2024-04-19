package code.wars.circular_list;

import java.util.ArrayList;
import java.util.Arrays;

public class CircularList<T> {

    private final ArrayList<T> list = new ArrayList<>();

    private int currentIndex;

    public CircularList(final T... elements) {

        if (elements.length == 0) {
            throw new RuntimeException("No elements were passed");
        }

        list.addAll(Arrays.asList(elements));
        currentIndex = -1;
    }

    T next() {

        if (currentIndex < list.size() - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        return list.get(currentIndex);
    }

    T prev() {

        if (currentIndex > 0) {
            currentIndex--;
        } else {
            currentIndex = list.size() - 1;
        }
        return list.get(currentIndex);
    }
}
