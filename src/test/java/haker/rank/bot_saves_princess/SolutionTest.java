package haker.rank.bot_saves_princess;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void displayPathToPrincess_whenFindsPath_returnInstructions() {

        // Given
        final String[] grid = {
                "---",
                "-m-",
                "p--"
        };

        // When
        final List<String> instructions = Solution.displayPathToPrincess(3, grid);

        // Then
        assertThat(instructions.size())
                .isEqualTo(2);
        assertThat(instructions)
                .containsExactlyInAnyOrder("DOWN", "LEFT");
    }
}