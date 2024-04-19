package code.wars.are_the_numbers_in_order;

public class Solution {

    public static boolean isAscOrder(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
