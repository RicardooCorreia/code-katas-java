package leetcode;

public class FindTheHighestAltitude {

    static class Solution {
        public int largestAltitude(int[] gain) {

            int maxAltitude = 0;
            int currentAltitude = 0;

            for (int j : gain) {
                currentAltitude += j;
                if (currentAltitude > maxAltitude) {
                    maxAltitude = currentAltitude;
                }
            }
            return maxAltitude;
        }
    }
}
