package code.wars.simple_remove_duplicates;

import java.util.ArrayList;

class Solution {

    public static int[] solve(int[] arr) {

        ArrayList<Integer> numbers = new ArrayList<>();
        for (Integer number : arr) {
            numbers.remove(number);
            numbers.add(number);
        }
        return numbers.stream().mapToInt(value -> value).toArray();
    }
}
