package haker.rank.game_of_thrones.one;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Nested
    class PositiveTests {
        @ParameterizedTest
        @ValueSource(strings = {
                "aaabbbb",
                "cdcdcdcdeeeef",
                "aabb",
                "aaa",
                "a"
        })
        void should_returnYes_when_stringCanBeRearrangedIntoPalindrome(String input) {
            // given
            // input from ValueSource

            // when
            String result = Result.gameOfThrones(input);

            // then
            assertThat(result).isEqualTo("YES");
        }
    }

    @Nested
    class NegativeTests {
        @ParameterizedTest
        @ValueSource(strings = {
                "cdefghmnopqrstuvw",
                "abc",
                "aaabbb"
        })
        void should_returnNo_when_stringCannotBeRearrangedIntoPalindrome(String input) {
            // given
            // input from ValueSource

            // when
            String result = Result.gameOfThrones(input);

            // then
            assertThat(result).isEqualTo("NO");
        }
    }
}
