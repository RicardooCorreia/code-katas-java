package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumPopulationYearTest {

    private final MaximumPopulationYear.Solution subject = new MaximumPopulationYear.Solution();

    @Test
    void maximumPopulation() {

        // Given
        int[][] logs = {
                {1993, 1999},
                {2000, 2010}
        };

        // When
        int result = subject.maximumPopulation(logs);

        // Then
        assertEquals(1993, result);
    }

    @Test
    void maximumPopulation_overalapingYears() {

        // Given
        int[][] logs = {
                {1950, 1961},
                {1960, 1971},
                {1970, 1981}
        };

        // When
        int result = subject.maximumPopulation(logs);

        // Then
        assertEquals(1960, result);
    }
}