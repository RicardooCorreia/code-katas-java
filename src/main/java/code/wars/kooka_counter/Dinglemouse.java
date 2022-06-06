package code.wars.kooka_counter;

import java.util.regex.Pattern;

public class Dinglemouse {

    public static int kookaCounter(final String laughing) {

        final Pattern femalePattern = Pattern.compile("(ha)+");
        final Pattern malePattern = Pattern.compile("(Ha)+");

        final int femaleCount = (int) femalePattern.matcher(laughing).results().count();
        final int maleCount = (int) malePattern.matcher(laughing).results().count();

        return femaleCount + maleCount;
    }
}
