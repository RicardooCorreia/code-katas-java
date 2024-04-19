package code.wars.evil_autocorrect_prank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void autocorrect_whenIsLetterU_returnReplaced() {

        // Given
        String input = Kata.autocorrect("u");

        // When
        String result = input;

        // Then
        assertThat(result)
                .isEqualTo("your sister");
    }

    @Test
    void autocorrect_whenIsLetterUppercaseU_returnReplaced() {

        // Given
        String input = Kata.autocorrect("U");

        // When
        String result = input;

        // Then
        assertThat(result)
                .isEqualTo("your sister");
    }

    @Test
    void autocorrect_whenIsWordYou_returnReplaced() {

        // Given
        String input = Kata.autocorrect("you");

        // When
        String result = input;

        // Then
        assertThat(result)
                .isEqualTo("your sister");
    }

    @Test
    void autocorrect_whenIsWordYouWithTraillingU_returnReplaced() {

        // Given
        String input = Kata.autocorrect("youuuuuu");

        // When
        String result = input;

        // Then
        assertThat(result)
                .isEqualTo("your sister");
    }

    @Test
    void autocorrect_whenIsWordYouCaseInsensitive_returnReplaced() {

        // Given
        String input = Kata.autocorrect("YoU");

        // When
        String result = input;

        // Then
        assertThat(result)
                .isEqualTo("your sister");
    }

    @Test
    void autocorrect_whenIsInsideOtherWord_returnNotReplaced() {

        // Given
        String input = Kata.autocorrect("youtube");

        // When
        String result = input;

        // Then
        assertThat(result)
                .isEqualTo("youtube");
    }
}
