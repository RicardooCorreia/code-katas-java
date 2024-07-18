package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]
Example 3:
    Input: nums = [1]
    Output: [[1]]

Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
 */
public class Permutations {

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> currentPermutations = getPermutations(nums, new HashSet<>(), new LinkedList<>());
            return new LinkedList<>(currentPermutations);
        }

        private List<List<Integer>> getPermutations(final int[] nums,
                                                    final Set<Integer> added,
                                                    final List<Integer> currentPermutation) {

            List<List<Integer>> permutations = new LinkedList<>();
            for (int num : nums) {
                if (!added.contains(num)) {
                    HashSet<Integer> newAdded = new HashSet<>(added);
                    List<Integer> permutation = new LinkedList<>(currentPermutation);
                    permutation.add(num);
                    newAdded.add(num);
                    if (permutation.size() < nums.length) {
                        permutations.addAll(getPermutations(nums, newAdded, permutation));
                    } else {
                        permutations.add(permutation);
                    }
                }
            }
            return permutations;
        }
    }
}
