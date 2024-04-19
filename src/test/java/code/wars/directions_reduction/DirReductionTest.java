package code.wars.directions_reduction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirReductionTest {

    @Test
    public void dirReduc_whenCanBeReducedToOneDirection_returnDirection() {

        // Given
        String[] input = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};

        // When
        String[] result = DirReduction.dirReduc(input);

        // Then
        assertThat(result)
                .containsExactly("WEST");
    }

    @Test
    public void dirReduc_whenCanBeReducedToNothing_returnEmpty() {

        // Given
        String[] input = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"};

        // When
        String[] result = DirReduction.dirReduc(input);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    public void dirReduc_whenCannotBeReduced_returnSame() {

        // Given
        String[] input = {"NORTH", "EAST", "NORTH", "EAST", "NORTH", "EAST"};

        // When
        String[] result = DirReduction.dirReduc(input);

        // Then
        assertThat(result)
                .containsExactly(input);
    }

    @Test
    public void dirReduc_whenCannotBeReducedAndHaveAllDirections_returnSame() {

        // Given
        String[] input = {"NORTH", "WEST", "SOUTH", "EAST"};

        // When
        String[] result = DirReduction.dirReduc(input);

        // Then
        assertThat(result)
                .containsExactly(input);
    }

    @Test
    public void dirReduc_whenCanReduceAndItsNotImmediatelyAfterButCanBeReduced_returnReduced() {

        // Given
        String[] input = {"NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"};

        // When
        String[] result = DirReduction.dirReduc(input);

        // Then
        assertThat(result)
                .containsExactly("WEST", "WEST");
    }
}
