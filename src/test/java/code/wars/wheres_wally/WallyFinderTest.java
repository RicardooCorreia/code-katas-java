package code.wars.wheres_wally;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WallyFinderTest {

    @ParameterizedTest(name = "[{argumentsWithNames}]")
    @ValueSource(strings = {
        "''",
        "DWally",
        ".Wally",
        "12Wally Wally01 W.ally"
    })
    void should_returnNegativeOne_when_wallyIsNotFound(
        // given
        String input) {

        // when
        int result = WallyFinder.wheresWally(input);

        // then
        assertThat(result)
            .isEqualTo(-1);
    }

    @ParameterizedTest(name = "[{argumentsWithNames}]")
    @CsvSource({
        "Wally,           0",
        "Where's Wally,   8",
        "Hi Wally.,       3"
    })
    void should_returnCorrectIndex_when_wallyIsFound(String input, int expectedIndex) {
        // given
        // input and expectedIndex from CsvSource

        // when
        int result = WallyFinder.wheresWally(input);

        // then
        assertThat(result).isEqualTo(expectedIndex);
    }
}