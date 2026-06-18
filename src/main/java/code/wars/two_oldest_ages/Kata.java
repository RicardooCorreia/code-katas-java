package code.wars.two_oldest_ages;

public class Kata {

    public static int[] twoOldestAges(int[] ages) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int age : ages) {
            if (firstMax < age) {
                secondMax = firstMax;
                firstMax = age;
            } else if (secondMax < age) {
                secondMax = age;
            }
        }

        return new int[]{secondMax, firstMax};
    }
}
