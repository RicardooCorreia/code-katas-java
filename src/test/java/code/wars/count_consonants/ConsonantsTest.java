package code.wars.count_consonants;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsonantsTest {

    @Test
    void getCount_whenEmpty_returnZero() {

        // Given
        String input = "";

        // When
        int result = Consonants.getCount(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void getCount_whenHasNoNone_returnZero() {

        // Given
        String input = "aaaaa";

        // When
        int result = Consonants.getCount(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }

    @Test
    void getCount_whenHasSome_returnCorrect() {

        // Given
        String input = "XaeiouX";

        // When
        int result = Consonants.getCount(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void getCount_whenAllLetters_returnCorrect() {

        // Given
        String input = "Bbbbb";

        // When
        int result = Consonants.getCount(input);

        // Then
        assertThat(result)
                .isEqualTo(5);
    }

    @Test
    void getCount_whenContainsSpecialLetters_returnCorrect() {

        // Given
        String input = "h^$&^#$&^elLo world";

        // When
        int result = Consonants.getCount(input);

        // Then
        assertThat(result)
                .isEqualTo(7);
    }

    @Test
    void getCount_whenHasOnlyNumber_returnZero() {

        // Given
        String input = "0123456789";

        // When
        int result = Consonants.getCount(input);

        // Then
        assertThat(result)
                .isEqualTo(0);
    }
}
