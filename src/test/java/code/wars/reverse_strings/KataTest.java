package code.wars.reverse_strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    public void sampleTests() {

        // given
        String input = "world";

        // when
        String result = Kata.solution(input);

        // then
        assertThat(result)
                .isEqualTo("dlrow");
    }
}