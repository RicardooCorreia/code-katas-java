package haker.rank.happy_ladybugs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ResultTest {

    public static Stream<Arguments> happyLadybugs() {

        return Stream.of(
                arguments("RBY_YBR"),
                arguments("B_RRBR"),
                arguments("B_RRBR"),
                arguments("AABBC_C"),
                arguments("DD__FQ_QQF")
        );
    }

    public static Stream<Arguments> sadLadybugs() {

        return Stream.of(
                arguments("X_Y__X"),
                arguments("AABBC"),
                arguments("AB")
        );
    }

    public static Stream<Arguments> noLadybugs() {

        return Stream.of(
                arguments("___"),
                arguments("__"),
                arguments("_")
        );
    }

    @ParameterizedTest
    @MethodSource("happyLadybugs")
    void happyLadybugs_whenItCanMakeThemAllHappy_returnYes(
            // Given
            String ladyBugs) {

        // When
        final String result = Result.happyLadybugs(ladyBugs);

        // Then
        assertThat(result)
                .isEqualTo("YES");
    }

    @ParameterizedTest
    @MethodSource("sadLadybugs")
    void happyLadybugs_whenItCantMakeThemAllHappy_returnNo(
            // Given
            String ladyBugs) {

        // When
        final String result = Result.happyLadybugs(ladyBugs);

        // Then
        assertThat(result)
                .isEqualTo("NO");
    }

    @ParameterizedTest
    @MethodSource("noLadybugs")
    void happyLadybugs_whenItNoLadyBugs_returnYes(
            // Given
            String ladyBugs) {

        // When
        final String result = Result.happyLadybugs(ladyBugs);

        // Then
        assertThat(result)
                .isEqualTo("YES");
    }

    @Test
    void happyLadybugs_whenAllLadyBugsHavePairButCannotMove_returnNo() {

        // Given
        final String ladybugs = "AABCBC";

        // When
        final String result = Result.happyLadybugs(ladybugs);

        // Then
        assertThat(result)
                .isEqualTo("NO");
    }

    @Test
    void happyLadybugs_whenAllSingleLadyBug_returnNO() {

        // Given
        final String ladybugs = "R";

        // When
        final String result = Result.happyLadybugs(ladybugs);

        // Then
        assertThat(result)
                .isEqualTo("NO");
    }
}