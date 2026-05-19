package code.wars.simple_consecutive_pairs;

class Solution {

    public static int solve(int[] arr) {

        int consecutive = 0;
        for (int i = 0; i < arr.length - 1; i += 2) {
            final int first = arr[i];
            final int second = arr[i + 1];
            if (first == second + 1 || first == second - 1) {
                consecutive++;
            }
        }
        return consecutive;
    }
}
