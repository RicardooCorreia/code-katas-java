package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceK {

    /**
     * Given a list of numbers `l` and a number `k`
     * determine if any two elems from the list have a difference of `k`
     * E.g:
     * - [1, 9, 6, 4] with diff 3 => true
     * - [-1, 2, 3, 4] with diff 3 => true
     * - [5, 15, 10] with diff 2 => false
     **/
    public boolean diffExists(List<Integer> l, int k) {

        ArrayList<Integer> numbers = new ArrayList<>(l);
        numbers.sort(Comparator.comparingInt(o -> o));
        Integer previousNumber = l.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Integer currentNumber = numbers.get(i);
            if (currentNumber - previousNumber == k) {
                return true;
            }
        }
        return false;
    }

    public boolean betterDiffExists(List<Integer> l, int k) {

        Set<Integer> seenNumbers = new HashSet<>();
        for (Integer number : l) {
            if (seenNumbers.contains(number - k) || seenNumbers.contains(number + k)) {
                return true;
            } else {
                seenNumbers.add(number);
            }
        }
        return false;
    }
}
