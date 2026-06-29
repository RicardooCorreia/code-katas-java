package code.wars.luxurious_house;

class Solution {
    public static int[] luxhouse(int[] houses) {

        int[] solution = new int[houses.length];
        int max = 0;
        for (var i = houses.length - 1; i >= 0; i--) {
            final var house = houses[i];
            if (house > max) {
                solution[i] = 0;
                max = house;
            } else {
                solution[i] = (max - house) + 1;
            }
        }
        return solution;
    }
}
