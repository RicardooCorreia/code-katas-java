package code.wars.simple_time_difference;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solve_whenSingleTime_return2359() {

        // Given
        String[] input = {"14:51"};

        // When
        String result = Solution.solve(input);

        // Then
        assertThat(result)
                .isEqualTo("23:59");
    }

    @Test
    void solve_whenMultipleTimes_returnLongestTime() {

        // Given
        String[] input = {"21:14", "15:34", "14:51", "06:25", "15:30"};

        // When
        String result = Solution.solve(input);

        // Then
        assertThat(result)
                .isEqualTo("09:10");
    }

    @Test
    void solve_whenWrapAcrossMidnight_returnLongestTime() {

        // Given
        String[] input = {"23:00","04:22","18:05","06:24"};

        // When
        String result = Solution.solve(input);

        // Then
        assertThat(result)
                .isEqualTo("11:40");
    }
}
