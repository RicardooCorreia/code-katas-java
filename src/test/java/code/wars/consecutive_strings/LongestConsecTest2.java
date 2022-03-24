package code.wars.consecutive_strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestConsecTest2 {


    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2, "abigailtheta"),
                arguments(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1, "oocccffuucccjjjkkkjyyyeehh"),
                arguments(new String[]{}, 3, ""),
                arguments(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2, "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"),
                arguments(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2, "wlwsasphmxxowiaxujylentrklctozmymu"),
                arguments(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2, ""),
                arguments(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3, "ixoyx3452zzzzzzzzzzzz"),
                arguments(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15, ""),
                arguments(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0, ""));
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void longestConsec_baseScenarios(
            // Given
            String[] words,
            int consectiveFactor,
            String expected
    ) {

        // When
        final String result = LongestConsec2.longestConsec(words, consectiveFactor);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
