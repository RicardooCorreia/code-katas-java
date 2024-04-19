package code.wars.translating_a_path;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void walk_whenHasOneInstruction_returnCorrect() {

        // Given
        String input = "^";

        // When
        String result = Solution.walk(input);

        // Then
        assertThat(result)
                .isEqualTo("Take 1 step up");
    }

    @Test
    void walk_whenHasMultipleInstructionSameDirection_returnCorrect() {

        // Given
        String input = ">>";

        // When
        String result = Solution.walk(input);

        // Then
        assertThat(result)
                .isEqualTo("Take 2 steps right");
    }

    @Test
    void walk_whenHasNoInstructions_returnPaused() {

        // Given
        String input = "";

        // When
        String result = Solution.walk(input);

        // Then
        assertThat(result)
                .isEqualTo("Paused");
    }

    @Test
    void walk_whenHasMultipleInstructions_returnCorrectPath() {

        // Given
        String input = "^^vvvv>><<^v>";

        // When
        String result = Solution.walk(input);

        // Then
        assertThat(result)
                .isEqualTo("Take 2 steps up\n" +
                                   "Take 4 steps down\n" +
                                   "Take 2 steps right\n" +
                                   "Take 2 steps left\n" +
                                   "Take 1 step up\n" +
                                   "Take 1 step down\n" +
                                   "Take 1 step right");
    }
}
