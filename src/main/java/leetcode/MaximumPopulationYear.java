package leetcode;

import java.util.Arrays;

/*
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
The population of some year x is the number of people alive during that year. The ith person is counted in
year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
Return the earliest year with the maximum population.

Example 1:
    Input: logs = [[1993,1999],[2000,2010]]
    Output: 1993
    Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
Example 2:
    Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
    Output: 1960
    Explanation:
        The maximum population is 2, and it had happened in years 1960 and 1970.
        The earlier year between them is 1960.

Constraints:
    1 <= logs.length <= 100
    1950 <= birthi < deathi <= 2050
 */
public class MaximumPopulationYear {

    static class Solution {

        public static final int MINIMUM_YEAR = 1950;
        public static final int MAXIMUM_YEAR = 2050;

        public int maximumPopulation(int[][] logs) {

            int[] populationAtYear = new int[MAXIMUM_YEAR - MINIMUM_YEAR];
            int maximumPopulation = Integer.MIN_VALUE;
            Arrays.fill(populationAtYear, 0);
            for (int[] log : logs) {

                int birthYearArrayIndex = log[0] - MINIMUM_YEAR;
                int deathYearArrayIndex = log[1] - MINIMUM_YEAR;

                for (int year = birthYearArrayIndex; year < deathYearArrayIndex; year++) {
                    populationAtYear[year]++;
                    maximumPopulation = Math.max(maximumPopulation, populationAtYear[year]);
                }
            }

            for (int i = 0; i < populationAtYear.length; i++) {
                int population = populationAtYear[i];
                if (population == maximumPopulation) {
                    return i + MINIMUM_YEAR;
                }
            }

            return 0;
        }
    }
}
