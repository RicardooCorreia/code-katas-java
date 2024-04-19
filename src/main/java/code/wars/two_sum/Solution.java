package code.wars.two_sum;

public class Solution {

    public static int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int num1 = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (num1 + numbers[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}
