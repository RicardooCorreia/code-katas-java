package leetcode;

import java.util.HashSet;

public class FindCenterOfStarGraph {

    static class Solution {
        public int findCenter(int[][] edges) {

            if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1]) {
                return edges[0][1];
            } else {
                return edges[0][0];
            }
        }
    }
}
