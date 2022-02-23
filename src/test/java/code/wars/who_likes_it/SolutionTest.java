package code.wars.who_likes_it;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void whoLikesIt_whenNoNames_returnNoOne() {

        // When
        final String result = Solution.whoLikesIt();

        // Then
        assertThat(result)
                .isEqualTo("no one likes this");
    }

    @Test
    void whoLikesIt_whenOneName_returnOneName() {

        // Given
        final String input = "Peter";

        // When
        final String result = Solution.whoLikesIt(input);

        // Then
        assertThat(result)
                .isEqualTo("Peter likes this");
    }

    @Test
    void whoLikesIt_whenTwoNames_returnTwoNames() {

        // Given
        final String input1 = "Jacob";
        final String input2 = "Alex";

        // When
        final String result = Solution.whoLikesIt(input1, input2);

        // Then
        assertThat(result)
                .isEqualTo("Jacob and Alex like this");
    }

    @Test
    void whoLikesIt_when3Names_return3Names() {

        // Given
        final String input1 = "Max";
        final String input2 = "John";
        final String input3 = "Mark";

        // When
        final String result = Solution.whoLikesIt(input1, input2, input3);

        // Then
        assertThat(result)
                .isEqualTo("Max, John and Mark like this");
    }

    @Test
    void whoLikesIt_whenMoreThan3Names_return2NamesAndOthers() {

        // Given
        final String input1 = "Alex";
        final String input2 = "Jacob";
        final String input3 = "Mark";
        final String input4 = "Max";

        // When
        final String result = Solution.whoLikesIt(input1, input2, input3, input4);

        // Then
        assertThat(result)
                .isEqualTo("Alex, Jacob and 2 others like this");
    }
}