package code.wars.find_all_pairs;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int duplicates(int[] array) {

        final Set<Integer> numbersWaitingForDuplicates = new HashSet<>();
        int duplicatesCount = 0;
        for (int element : array) {
            if (numbersWaitingForDuplicates.contains(element)) {
                numbersWaitingForDuplicates.remove(element);
                duplicatesCount++;
            } else {
                numbersWaitingForDuplicates.add(element);
            }
        }
        return duplicatesCount;
    }
}
