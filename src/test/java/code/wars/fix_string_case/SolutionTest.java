package code.wars.fix_string_case;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void solve_whenNoChangeIsNeeded_returnSame() {

        // Given
        String input = "code";

        // When
        String result = Solution.solve(input);

        // Then

        assertThat(result)
                .isEqualTo("code");
    }

    @Test
    public void solve_whenMostAreUpperCase_returnFixed() {

        // Given
        String input = "CODe";

        // When
        String result = Solution.solve(input);

        // Then

        assertThat(result)
                .isEqualTo("CODE");
    }

    @Test
    public void solve_whenMostAreLowerCase_returnFixed() {

        // Given
        String input = "Code";

        // When
        String result = Solution.solve(input);

        // Then

        assertThat(result)
                .isEqualTo("code");
    }

    @Test
    public void solve_whenMostLowerCaseIsEqualToUpper_returnLowerCase() {

        // Given
        String input = "COde";

        // When
        String result = Solution.solve(input);

        // Then

        assertThat(result)
                .isEqualTo("code");
    }

    @Test
    public void solve_whenEmpty_returnEmpty() {

        // Given
        String input = "";

        // When
        String result = Solution.solve(input);

        // Then

        assertThat(result)
                .isEqualTo("");
    }
}
