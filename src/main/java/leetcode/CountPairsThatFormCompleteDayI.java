package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array hours representing times in hours, return an integer denoting the number of pairs i, j
    where i < j and hours[i] + hours[j] forms a complete day.
A complete day is defined as a time duration that is an exact multiple of 24 hours.
For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and so on.

Example 1:
    Input: hours = [12,12,30,24,24]
    Output: 2
    Explanation:
        The pairs of indices that form a complete day are (0, 1) and (3, 4).
Example 2:
    Input: hours = [72,48,24,3]
    Output: 3
    Explanation:
        The pairs of indices that form a complete day are (0, 1), (0, 2), and (1, 2).

Constraints:
    1 <= hours.length <= 100
    1 <= hours[i] <= 109
 */
public class CountPairsThatFormCompleteDayI {

    static class Solution {
        public int countCompleteDayPairs(int[] hours) {

            int fullDays = 0;
            int partialDays = 0;
            HashMap<Integer, Integer> otherHours = new HashMap<>();
            int otherHoursDays = 0;

            for (int hour : hours) {
                if (hour % 24 == 0) {
                    fullDays++;
                } else if (hour % 12 == 0) {
                    partialDays++;
                } else {
                    int deductedHour = hour % 24;
                    int hourToSearch = 24 - deductedHour;
                    if (otherHours.containsKey(hourToSearch)) {
                        otherHoursDays += otherHours.get(hourToSearch);
                    }
                    otherHours.putIfAbsent(deductedHour, 0);
                    otherHours.put(deductedHour, otherHours.get(deductedHour) + 1);
                }
            }

            return getPairCount(fullDays) + getPairCount(partialDays) + otherHoursDays;
        }

        private static int getPairCount(int count) {
            return (int) (0.5 * (count - 1) * count);
        }
    }
}
