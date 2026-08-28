package code.wars.can_you_win_the_codewar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.can_you_win_the_codewar.Kata.codewarResult;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @MethodSource("stalemateCases")
    void should_returnStalemate_when_armiesTie(
        // given
        int[] codewarrior, int[] opponent) {

        // when
        String result = codewarResult(codewarrior, opponent);

        // then
        assertThat(result).isEqualTo("Stalemate");
    }

    @ParameterizedTest
    @MethodSource("victoryCases")
    void should_returnVictory_when_codewarriorWins(
        // given
        int[] codewarrior, int[] opponent) {

        // when
        String result = codewarResult(codewarrior, opponent);

        // then
        assertThat(result).isEqualTo("Victory");
    }

    @ParameterizedTest
    @MethodSource("defeatCases")
    void should_returnDefeat_when_opponentWins(
        // given
        int[] codewarrior, int[] opponent) {

        // when
        String result = codewarResult(codewarrior, opponent);

        // then
        assertThat(result).isEqualTo("Defeat");
    }

    static Stream<Arguments> victoryCases() {
        return Stream.of(
            Arguments.of(new int[]{2, 4, 3, 1}, new int[]{4, 5, 1, 2}),
            Arguments.of(new int[]{11, 18, 22, 12, 19}, new int[]{23, 17, 15, 22, 21}),
            Arguments.of(
                new int[]{2, 2, 4, 2, 2, 4, 3, 2, 2, 3, 2, 3, 2, 1, 3, 1, 2, 3, 4, 3, 1, 4, 2, 1, 2, 3, 3, 1, 1, 2, 3, 2, 2, 4, 3, 2, 2},
                new int[]{1, 4, 3, 1, 3, 4, 3, 4, 3, 3, 4, 3, 1, 1, 3, 2, 2, 4, 2, 4, 4, 4, 2, 3, 2, 4, 2, 2, 1, 3, 4, 1, 1, 4, 2, 3, 4}));
    }

    static Stream<Arguments> stalemateCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 4, 1}, new int[]{1, 5, 3}), // 4,1,1 vs 5,3,1 -> 4-3/1-1/1-5
            Arguments.of(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}),
            Arguments.of(
                new int[]{2, 1, 3, 1, 1, 3, 3, 2, 3, 1, 1, 1, 3, 1, 3, 1, 3, 3, 1, 2, 3, 3, 1, 3},
                new int[]{4, 4, 1, 4, 3, 1, 4, 4, 3, 2, 1, 2, 1, 3, 3, 1, 4, 4, 3, 2, 3, 2, 4, 1}));
    }

    static Stream<Arguments> defeatCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 2, 1}, new int[]{3, 1, 2, 3}),
            Arguments.of(new int[]{5}, new int[]{6}));
    }
}
