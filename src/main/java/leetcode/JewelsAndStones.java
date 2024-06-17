package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class JewelsAndStones {
    static class Solution {
        public int numJewelsInStones(String jewels, String stones) {

            Set<String> jewelSet = Arrays.stream(jewels.split(""))
                    .collect(Collectors.toSet());

            return (int) Arrays.stream(stones.split(""))
                    .filter(jewelSet::contains)
                    .count();
        }
    }
}
