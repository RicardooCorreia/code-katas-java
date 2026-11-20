package code.wars.the_12_days_of_christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DinglemouseTest {

    private static final String[] SONG = {
            "On the 12th day of Christmas my true love gave to me",
            "12 drummers drumming,",
            "11 pipers piping,",
            "10 lords a leaping,",
            "9 ladies dancing,",
            "8 maids a milking,",
            "7 swans a swimming,",
            "6 geese a laying,",
            "5 golden rings,",
            "4 calling birds,",
            "3 French hens,",
            "2 turtle doves and",
            "a partridge in a pear tree."
    };

    @Test
    void should_sortSongLines_when_linesAreInReverseOrder() {
        // given
        List<String> lines = new ArrayList<>(Arrays.asList(SONG));
        Collections.reverse(lines);
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        Collections.sort(lines, comparator);

        // then
        assertThat(lines).containsExactly(SONG);
    }

    @Test
    void should_sortSongLines_when_linesAreAlreadyInOrder() {
        // given
        List<String> lines = new ArrayList<>(Arrays.asList(SONG));
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        Collections.sort(lines, comparator);

        // then
        assertThat(lines).containsExactly(SONG);
    }

    @Test
    void should_returnNegative_when_introLineComparedWithNumberedLine() {
        // given
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        int result = comparator.compare("On the 12th day of Christmas my true love gave to me", "12 drummers drumming,");

        // then
        assertThat(result).isNegative();
    }

    @Test
    void should_returnNegative_when_higherNumberComparedWithLowerNumber() {
        // given
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        int result = comparator.compare("12 drummers drumming,", "11 pipers piping,");

        // then
        assertThat(result).isNegative();
    }

    @Test
    void should_returnPositive_when_lowerNumberComparedWithHigherNumber() {
        // given
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        int result = comparator.compare("2 turtle doves and", "3 French hens,");

        // then
        assertThat(result).isPositive();
    }

    @Test
    void should_returnNegative_when_numberedLineComparedWithPartridgeLine() {
        // given
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        int result = comparator.compare("2 turtle doves and", "a partridge in a pear tree.");

        // then
        assertThat(result).isNegative();
    }

    @Test
    void should_returnPositive_when_partridgeLineComparedWithNumberedLine() {
        // given
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        int result = comparator.compare("a partridge in a pear tree.", "2 turtle doves and");

        // then
        assertThat(result).isPositive();
    }

    @Test
    void should_returnZero_when_sameLineComparedWithItself() {
        // given
        Dinglemouse.HelpSaveChristmas comparator = new Dinglemouse.HelpSaveChristmas();

        // when
        int result = comparator.compare("5 golden rings,", "5 golden rings,");

        // then
        assertThat(result).isZero();
    }
}
