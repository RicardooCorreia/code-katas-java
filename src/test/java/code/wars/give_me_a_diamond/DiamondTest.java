package code.wars.give_me_a_diamond;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiamondTest {

    @Test
    public void print_when3_returnDiamond() {

        // Given
        final int input = 3;

        // When
        final String result = Diamond.print(input);

        // Then
        String expected = """
                 *
                ***
                 *
                """;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void print_when5_returnDiamond() {

        // Given
        final int input = 5;

        // When
        final String result = Diamond.print(input);

        // Then
        String expected = """
                  *
                 ***
                *****
                 ***
                  *
                """;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void print_when1_returnDiamond() {

        // Given
        final int input = 1;

        // When
        final String result = Diamond.print(input);

        // Then
        String expected = "*\n";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void print_when15_returnDiamond() {

        // Given
        final int input = 15;

        // When
        final String result = Diamond.print(input);

        // Then
        String expected = """
                       *
                      ***
                     *****
                    *******
                   *********
                  ***********
                 *************
                ***************
                 *************
                  ***********
                   *********
                    *******
                     *****
                      ***
                       *
                """;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void print_when0_returnNull() {

        // Given
        final int input = 0;

        // When
        final String result = Diamond.print(input);

        // Then

        assertThat(result).isEqualTo(null);
    }

    @Test
    public void print_whenNegative_returnNull() {

        // Given
        final int input = -2;

        // When
        final String result = Diamond.print(input);

        // Then

        assertThat(result).isEqualTo(null);
    }

    @Test
    public void print_whenNumberIsEven_returnNull() {

        // Given
        final int input = 2;

        // When
        final String result = Diamond.print(input);

        // Then

        assertThat(result).isEqualTo(null);
    }
}
