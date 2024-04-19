package code.wars.street_fighter_character_selection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    private static final String[][] FIGHTERS = new String[][]{
            new String[]{"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
            new String[]{"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"},
    };

    @Test
    public void streetFighterSelection_whenNoMoves_returnEmpty() {

        // Given
        final int[] start = {0, 0};
        final String[] moves = {};

        // When
        final String[] result = Solution.streetFighterSelection(FIGHTERS, start, moves);

        // Then
        assertThat(result).isEqualTo(new String[]{});
    }

    @Test
    public void streetFighterSelection_whenFewMoves_returnHoveredCharacters() {

        // Given
        final int[] start = {0, 0};
        final String[] moves = new String[]{"up", "left", "right", "left", "left"};

        // When
        final String[] result = Solution.streetFighterSelection(FIGHTERS, start, moves);

        // Then
        assertThat(result).isEqualTo(new String[]{"Ryu", "Vega", "Ryu", "Vega", "Balrog"});
    }

    @Test
    public void streetFighterSelection_whenAlwaysMovingLeft_returnCorrectCharacters() {

        // Given
        final int[] start = {0, 0};
        final String[] moves = new String[]{"left", "left", "left", "left", "left", "left", "left", "left"};

        // When
        final String[] result = Solution.streetFighterSelection(FIGHTERS, start, moves);

        // Then
        assertThat(result).isEqualTo(new String[]{"Vega", "Balrog", "Guile", "Blanka", "E.Honda", "Ryu", "Vega", "Balrog"});
    }

    @Test
    public void streetFighterSelection_whenAlwaysMovingRight_returnCorrectCharacters() {

        // Given
        final int[] start = {0, 0};
        final String[] moves = new String[]{"right", "right", "right", "right", "right", "right", "right", "right"};

        // When
        final String[] result = Solution.streetFighterSelection(FIGHTERS, start, moves);

        // Then
        assertThat(result).isEqualTo(new String[]{"E.Honda", "Blanka", "Guile", "Balrog", "Vega", "Ryu", "E.Honda", "Blanka"});
    }

    @Test
    public void streetFighterSelection_whenAll4DirectionsClockwiseTwice_shouldReturnSameCharacters() {

        // Given
        final int[] start = {0, 0};
        final String[] moves = new String[]{"up", "left", "down", "right", "up", "left", "down", "right"};

        // When
        final String[] result = Solution.streetFighterSelection(FIGHTERS, start, moves);

        // Then
        assertThat(result).isEqualTo(new String[]{"Ryu", "Vega", "M.Bison", "Ken", "Ryu", "Vega", "M.Bison", "Ken"});
    }

    @Test
    public void streetFighterSelection_whenAlwaysMovingDown_returnCorrect() {

        // Given
        final int[] start = {0, 0};
        final String[] moves = new String[]{"down", "down", "down", "down"};

        // When
        final String[] result = Solution.streetFighterSelection(FIGHTERS, start, moves);

        // Then
        assertThat(result).isEqualTo(new String[]{"Ken", "Ken", "Ken", "Ken"});
    }

    @Test
    public void streetFighterSelection_whenAlwaysMovingUp_returnCorrect() {

        // Given
        final int[] start = {0, 0};
        final String[] moves = new String[]{"up", "up", "up", "up"};

        // When
        final String[] result = Solution.streetFighterSelection(FIGHTERS, start, moves);

        // Then
        assertThat(result).isEqualTo(new String[]{"Ryu", "Ryu", "Ryu", "Ryu"});
    }
}
