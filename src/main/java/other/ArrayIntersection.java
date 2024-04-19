package other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    /**
     * Given two arrays, each containing unique numbers, return an array containing the intersection
     * That is, if a number is present in both arrays it should be included in the return
     * E.g:
     * - [3,4,2,7,9] and [6,1,9,3,0] should return [3, 9] or [9, 3] (order not important)
     * - [1,5,2,9,4] and [0,6,11,7,3] should return []
     **/
    public Integer[] intersection(Integer[] inputA, Integer[] inputB) {

        Set<Integer> seenNumbers = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        int maxLength = Math.max(inputA.length, inputB.length);
        for (int i = 0; i < maxLength; i++) {
            addNumber(inputA, seenNumbers, result, i);
            addNumber(inputB, seenNumbers, result, i);
        }

        return result.toArray(new Integer[0]);
    }

    private static void addNumber(Integer[] input, Set<Integer> seenNumbers, ArrayList<Integer> result, int i) {

        if (input.length > i) {
            Integer number = input[i];
            if (seenNumbers.contains(number)) {
                result.add(number);
            } else {
                seenNumbers.add(number);
            }
        }
    }
}
