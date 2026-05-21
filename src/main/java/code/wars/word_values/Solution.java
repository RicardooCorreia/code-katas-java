package code.wars.word_values;

class Solution {

    public static int[] nameValue(String[] arr) {

        int[] sums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sums[i] = calculate(arr[i]) * (i + 1);
        }
        return sums;
    }

    private static int calculate(String part) {
        return part.chars()
            .filter(Character::isAlphabetic)
            .map(c -> c - 96)
            .sum();
    }
}
