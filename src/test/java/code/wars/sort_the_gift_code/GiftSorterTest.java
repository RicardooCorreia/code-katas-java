package code.wars.sort_the_gift_code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GiftSorterTest {

    @ParameterizedTest
    @CsvSource({"fedcba, abcdef", "zyxwvutsrqponmlkjihgfedcba, abcdefghijklmnopqrstuvwxyz"})
    void should_returnSortedString_when_giftCodeIsUnsorted(String input, String expected) {
        // given
        var giftSorter = new GiftSorter();

        // when
        var result = giftSorter.sortGiftCode(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}