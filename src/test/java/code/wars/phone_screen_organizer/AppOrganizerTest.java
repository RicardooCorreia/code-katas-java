package code.wars.phone_screen_organizer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppOrganizerTest {

    @Test
    public void moveOver_whenSingle_returnCorrect() {

        // Given
        Object[] input = new Object[]{"a"};

        // When
        Object[] result = AppOrganizer.moveOver(input);

        // Then
        assertThat(result)
                .isEqualTo(input);
    }

    @Test
    public void moveOver_whenNull_returnEmpty() {

        // Given
        Object[] input = new Object[]{null};

        // When
        Object[] result = AppOrganizer.moveOver(input);

        // Then
        assertThat(result)
                .isEqualTo(new Object[0]);
    }

    @Test
    public void moveOver_wheMultipleNull_returnEmpty() {

        // Given
        Object[] input = new Object[]{null, null, null};

        // When
        Object[] result = AppOrganizer.moveOver(input);

        // Then
        assertThat(result)
                .isEqualTo(new Object[0]);
    }

    @Test
    public void moveOver_whenHasEmptySpace_moveOtherApp() {

        // Given
        Object[] input = {null, "a"};

        // When
        Object[] result = AppOrganizer.moveOver(input);

        // Then
        Object[] expected = new Object[]{"a"};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void moveOver_whenHasEmptySpace_moveAppToRight() {

        // Given
        Object[] input = {null, "a", "b"};

        // When
        Object[] result = AppOrganizer.moveOver(input);

        // Then
        Object[] expected = new Object[]{"b", "a"};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void moveOver_whenHasEmptySpace_moveAppToRightThatIsNotNull() {

        // Given
        Object[] input = {null, "a", "b", null};

        // When
        Object[] result = AppOrganizer.moveOver(input);

        // Then
        Object[] expected = new Object[]{"b", "a"};
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void moveOver_whenHasMultipleEmptySpaces_moveAppToRightThatIsNotNull() {

        // Given
        Object[] input = {null, null, "a", null, null, "b", null, null};

        // When
        Object[] result = AppOrganizer.moveOver(input);

        // Then
        Object[] expected = new Object[]{"b", "a"};
        assertThat(result)
                .isEqualTo(expected);
    }
}
