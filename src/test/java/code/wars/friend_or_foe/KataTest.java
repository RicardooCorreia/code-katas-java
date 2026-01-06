package code.wars.friend_or_foe;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void friend_example() {

        // Given
        List<String> input = List.of("Ryan   ", "Kieran  ", "Jason", "  Yous  ");

        // When
        List<String> result = Kata.friend(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("Ryan", "Yous");
    }
}
