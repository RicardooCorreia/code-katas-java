package code.wars.the_12_days_of_christmas;

import java.util.Comparator;
import java.util.List;

public class Dinglemouse {

    public static class HelpSaveChristmas implements Comparator<String> {

        private static final List<String> VERSES = List.of(
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
        );

        @Override
        public int compare(final String line1, final String line2) {

            return VERSES.indexOf(line1) - VERSES.indexOf(line2);
        }
    }
}
