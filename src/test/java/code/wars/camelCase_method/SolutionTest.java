package code.wars.camelCase_method;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void testTwoWords() {

        // Given
        String input = "test case";

        // When
        String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("TestCase");
    }

    @Test
    public void testThreeWords() {

        // Given
        String input = "camel case method";

        // When
        String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("CamelCaseMethod");
    }

    @Test
    public void testLeadingSpace() {

        // Given
        String input = " camel case word";

        // When
        String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("CamelCaseWord");
    }

    @Test
    public void testTrailingSpace() {

        // Given
        String input = "say hello ";

        // When
        String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("SayHello");
    }

    @Test
    public void testSingleLetter() {

        // Given
        String input = "z";

        // When
        String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("Z");
    }

    @Test
    public void testTwoSpacesBetweenWords() {

        // Given
        String input = "ab  c";

        // When
        String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("AbC");
    }

    @Test
    public void testEmptyString() {

        // Given
        String input = "";

        // When
        String result = Solution.camelCase(input);

        // Then
        assertThat(result)
                .isEqualTo("");
    }
}
