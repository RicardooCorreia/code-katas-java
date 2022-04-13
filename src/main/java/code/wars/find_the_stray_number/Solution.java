package code.wars.find_the_stray_number;

class Solution {
    static int stray(int[] numbers) {

        final int baseNumber = numbers[0];
        if (numbers[1] != baseNumber && numbers[2] != baseNumber) {
            return baseNumber;
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != baseNumber) {
                return numbers[i];
            }
        }
        return 0;
    }
}
