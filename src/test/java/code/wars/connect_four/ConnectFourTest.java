package code.wars.connect_four;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectFourTest {

    @Test
    public void whoIsWinner_whenWinnerIsYellow_returnYellow() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "G_Red",
                "B_Yellow"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Yellow");
    }

    @Test
    public void whoIsWinner_whenWinnerIsYellowWithMultiplePlays_returnYellow() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "C_Yellow",
                "E_Red",
                "G_Yellow",
                "B_Red",
                "D_Yellow",
                "B_Red",
                "B_Yellow",
                "G_Red",
                "C_Yellow",
                "C_Red",
                "D_Yellow",
                "F_Red",
                "E_Yellow",
                "A_Red",
                "A_Yellow",
                "G_Red",
                "A_Yellow",
                "F_Red",
                "F_Yellow",
                "D_Red",
                "B_Yellow",
                "E_Red",
                "D_Yellow",
                "A_Red",
                "G_Yellow",
                "D_Red",
                "D_Yellow",
                "C_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Yellow");
    }

    @Test
    public void whoIsWinner_whenWinnerIsRed_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "A_Yellow",
                "B_Red",
                "B_Yellow",
                "C_Red",
                "G_Yellow",
                "C_Red",
                "C_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "F_Yellow",
                "E_Red",
                "D_Yellow"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }

    @Test
    public void whoIsWinner_whenRedWinsVertically_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "A_Yellow",
                "B_Red",
                "C_Yellow",
                "B_Red",
                "G_Yellow",
                "B_Red",
                "C_Yellow",
                "B_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }

    @Test
    public void whoIsWinner_whenRedWinsVerticallyButAfterSomePlays_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "A_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "B_Red",
                "C_Yellow",
                "B_Red",
                "G_Yellow",
                "B_Red",
                "C_Yellow",
                "B_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }@Test
    public void whoIsWinner_whenRedWinsVerticallyInLimit_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "A_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "B_Red",
                "C_Yellow",
                "B_Red",
                "G_Yellow",
                "B_Red",
                "C_Yellow",
                "B_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }

    @Test
    public void whoIsWinner_whenRedWinsHorizontally_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "A_Red",
                "A_Yellow",
                "B_Red",
                "B_Yellow",
                "C_Red",
                "C_Yellow",
                "D_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }

    @Test
    public void whoIsWinner_whenRedWinsHorizontallyAfterSomePlays_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "A_Yellow",
                "F_Red",
                "G_Yellow",
                "A_Red",
                "F_Yellow",
                "E_Red",
                "F_Yellow",
                "C_Red",
                "A_Yellow",
                "B_Red",
                "C_Yellow",
                "D_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }

    @Test
    public void whoIsWinner_whenRedWinsRightCross_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "D_Red",
                "E_Yellow",
                "F_Red",
                "G_Yellow",
                "E_Red",
                "F_Yellow",
                "G_Red",
                "G_Yellow",
                "G_Red",
                "A_Yellow",
                "F_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }

    @Test
    public void whoIsWinner_whenRedWinsLeftCross_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "D_Red",
                "C_Yellow",
                "B_Red",
                "A_Yellow",
                "C_Red",
                "B_Yellow",
                "A_Red",
                "A_Yellow",
                "A_Red",
                "G_Yellow",
                "B_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }

    @Test
    public void whoIsWinner_edgeCase_returnRed() {

        // Given
        List<String> input = new ArrayList<>(Arrays.asList(
                "E_Yellow",
                "E_Red",
                "G_Yellow",
                "E_Red",
                "D_Yellow",
                "A_Red",
                "C_Yellow",
                "B_Red",
                "D_Yellow",
                "A_Red",
                "G_Yellow",
                "F_Red",
                "E_Yellow",
                "G_Red",
                "C_Yellow",
                "D_Red",
                "G_Yellow",
                "F_Red",
                "F_Yellow",
                "G_Red",
                "C_Yellow",
                "F_Red",
                "G_Yellow",
                "B_Red",
                "F_Yellow",
                "C_Red",
                "C_Yellow",
                "C_Red",
                "A_Yellow",
                "E_Red",
                "D_Yellow",
                "E_Red",
                "D_Yellow",
                "F_Red",
                "B_Yellow",
                "A_Red",
                "A_Yellow",
                "D_Red",
                "B_Yellow",
                "B_Red",
                "A_Yellow",
                "B_Red"
        ));

        // When
        final String result = ConnectFour.whoIsWinner(input);

        // Then
        assertThat(result)
                .isEqualTo("Red");
    }
}