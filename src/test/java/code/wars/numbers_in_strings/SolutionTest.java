package code.wars.numbers_in_strings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    public static Stream<Arguments> sampleCases() {

        return Stream.of(
                Arguments.arguments("2ti9iei7qhr5", 9),
                Arguments.arguments("gh12cdy695m1", 695),
                Arguments.arguments("lu1j8qbbb85", 85),
                Arguments.arguments("185lu1j8qbbb85", 185)
        );
    }

    @ParameterizedTest
    @MethodSource("sampleCases")
    void should_return_largest_number_when_string_has_several_number_groups(
            // given
            String input,
            int expected) {

        // when
        int result = Solution.solve(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void should_return_that_number_when_string_has_a_single_number_group() {
        // given
        String input = "abc123def";

        // when
        int result = Solution.solve(input);

        // then
        assertThat(result).isEqualTo(123);
    }

    @Test
    void should_return_that_number_when_all_number_groups_are_equal() {
        // given
        String input = "a7b7c7";

        // when
        int result = Solution.solve(input);

        // then
        assertThat(result).isEqualTo(7);
    }

    @Test
    void should_compare_by_value_when_shorter_group_starts_with_bigger_digit() {
        // given
        String input = "a9b10";

        // when
        int result = Solution.solve(input);

        // then
        assertThat(result).isEqualTo(10);
    }
}
