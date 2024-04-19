package code.wars.split_strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitTest {

    @Test
    public void solution_whenEvenString_returnParisOfLetters() {

        // Given
        String input = "HelloWorld";

        // When
        String[] result = StringSplit.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"He", "ll", "oW", "or", "ld"});
    }

    @Test
    public void solution_whenOddString_returnWithEmptySpace() {

        // Given
        String input = "LovePizza";

        // When
        String[] result = StringSplit.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"Lo", "ve", "Pi", "zz", "a_"});
    }

    @Test
    public void solution_whenSingleChar_returnCorrect() {

        // Given
        String input = "I";

        // When
        String[] result = StringSplit.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"I_"});
    }

    @Test
    public void solution_whenEmpty_returnCorrect() {

        // Given
        String input = "";

        // When
        String[] result = StringSplit.solution(input);

        // Then
        assertThat(result)
                .isEqualTo(new String[0]);
    }
}
