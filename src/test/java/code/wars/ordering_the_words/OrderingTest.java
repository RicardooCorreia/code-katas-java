package code.wars.ordering_the_words;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class OrderingTest {

    Ordering order = new Ordering();

    @ParameterizedTest
    @MethodSource
    void should_returnSortedCharacters_when_inputIsValid(String input, String expected) {
        // given - input from MethodSource

        // when
        String result = order.orderWord(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> should_returnSortedCharacters_when_inputIsValid() {
        return Stream.of(
                Arguments.of("Hello, World!", " !,HWdellloor"),
                Arguments.of("completesolution", "ceeillmnooopsttu"),
                Arguments.of("\"][@!#$*(^&%", "!\"#$%&(*@[]^"),
                Arguments.of("i\"d][@z!#$r(^a&world%", "!\"#$%&(@[]^addilorrwz"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_returnInvalidString_when_inputIsNullOrEmpty(String input) {
        // given - input from NullAndEmptySource

        // when
        String result = order.orderWord(input);

        // then
        assertThat(result).isEqualTo("Invalid String!");
    }
}