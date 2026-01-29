package code.wars.the_hunger_games_zoo_disaster;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DinglemouseTest {

    @Test
    void whoEatsWho_example() {

        // Given
        String input = "fox,bug,chicken,grass,sheep";

        // When
        String[] result = Dinglemouse.whoEatsWho(input);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{
                        "fox,bug,chicken,grass,sheep",
                        "chicken eats bug",
                        "fox eats chicken",
                        "sheep eats grass",
                        "fox eats sheep",
                        "fox"
                });
    }
}
