package code.wars.lucky_number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LuckyNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1892376})
    void should_returnTrue_when_numberIsLucky(int input) {
        // given
        // input from ValueSource

        // when
        boolean result = LuckyNumber.isLucky(input);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void should_returnFalse_when_numberIsNotLucky() {
        // given
        int input = 189237;

        // when
        boolean result = LuckyNumber.isLucky(input);

        // then
        assertThat(result).isFalse();
    }
}
