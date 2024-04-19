package code.wars.kingdoms.archery_tournament;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void countAndSort_whenHasMoreArrows_returnWinner() {

        // Given
        final String[] target = {
                "z**",
                "a**",
                "**z"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("a", "z");
    }

    @Test
    void countAndSort_whenHasSameArrowsButShotInTheMiddle_returnWinner() {

        // Given
        final String[] target = {
                "z**",
                "*a*",
                "***"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("z", "a");
    }

    @Test
    void countAndSort_whenHasSamePointsButLessArrows_returnWinnerWithLessArrows() {

        // Given
        final String[] target = {
                "z**",
                "*a*",
                "***"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("z", "a");
    }

    @Test
    void countAndSort_whenHasArrowTwiceInSameSpotAndSamePointsAsOtherPlayer_returnWinnerWithLessArrowsAndSecondPlaceByDescendingOrderAlphabetically() {

        // Given
        final String[] target = {
                "z*B",
                "*a*",
                "**z"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("b", "z", "a");
    }

    @Test
    void countAndSort_whenLargerTarget_returnWinner() {

        // Given
        final String[] target = {
                "a****",
                "*****",
                "**z**",
                "a*k**",
                "****z"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("a", "k", "z");
    }

    @Test
    void countAndSort_whenLargerTargetWithMultipleArrows_returnWinner() {

        // Given
        final String[] target = {
                "a*****S",
                "*******",
                "**z****",
                "a*kOA**",
                "***L**z",
                "*****gG",
                "******z"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("s", "k", "g", "z", "l", "a", "o");
    }

    @Test
    void countAndSort_whenHasSamePointsAndSameArrows_returnWinnerByDescendingOrderAlphabetically() {

        // Given
        final String[] target = {
                "*a*",
                "***",
                "*b*"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("a", "b");
    }

    @Test
    void countAndSort_whenHasSingleTileAndDoubleArrow_returnWinner() {

        // Given
        final String[] target = {
                "A"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("a");
    }

    @Test
    void countAndSort_whenHasEmptyTarget_returnEmpty() {

        // Given
        final String[] target = {
                "*"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .isEmpty();
    }

    @Test
    void countAndSort_whenIsEdgeCase_returnCorrectResult() {

        // Given
        final String[] target = {
                "**f*c*f**",
                "*Yf*yAF**",
                "Z*D***e**",
                "*dy**d*d*",
                "**Ze***Dd",
                "**Z*e*Y*A",
                "Da*yfC***",
                "F***Y*z**",
                "zez***f**"
        };

        // When
        final String[] result = Kata.countAndSort(target);

        // Then
        assertThat(result)
                .containsExactly("c", "a", "e", "f", "z", "d", "y");
    }
}
