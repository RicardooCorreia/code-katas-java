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

        /*
        fox can't eat bug
            "fox,bug,chicken,grass,sheep"
        2	bug can't eat anything
            "fox,bug,chicken,grass,sheep"
        3	chicken eats bug
            "fox,chicken,grass,sheep"
        4	fox eats chicken
            "fox,grass,sheep"
        5	fox can't eat grass
            "fox,grass,sheep"
        6	grass can't eat anything
            "fox,grass,sheep"
        7	sheep eats grass
            "fox,sheep"
        8	fox eats sheep
            "fox"
         */
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
