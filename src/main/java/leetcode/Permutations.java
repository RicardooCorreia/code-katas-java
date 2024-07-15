package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
