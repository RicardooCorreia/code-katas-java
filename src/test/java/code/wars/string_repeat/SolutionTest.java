package code.wars.string_repeat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void repeatStr_singleLetter_returnCorrect() {

        // Given
        String input = "a";

        // When
        String result = Solution.repeatStr(4, input);

        // Then
        assertThat(result).isEqualTo("aaaa");
    }

    @Test
    public void repeatStr_singleWord_returnCorrect() {

        // Given
        String input = "Hello";

        // When
        String result = Solution.repeatStr(3, input);

        // Then
        assertThat(result).isEqualTo("HelloHelloHello");
    }

    @Test
    public void repeatStr_whenEmpty_returnEmpty() {

        // Given
        String input = "";

        // When
        String result = Solution.repeatStr(5, input);

        // Then
        assertThat(result).isEqualTo("");
    }

    @Test
    public void repeatStr_whenRepeat5_returnEmpty() {

        // Given
        String input = "kata";

        // When
        String result = Solution.repeatStr(0, input);

        // Then
        assertThat(result).isEqualTo("");
    }
}
