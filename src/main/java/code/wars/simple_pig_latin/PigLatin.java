package code.wars.simple_pig_latin;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatin {

    private static final String SUFFIX = "ay";
    public static final String SPACE = " ";
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]");

    public static String pigIt(String phrase) {

        return Arrays.stream(phrase.split(SPACE))
                .map(PigLatin::wordToLatinPig)
                .collect(Collectors.joining(SPACE));
    }

    private static String wordToLatinPig(String word) {

        if (!PATTERN.matcher(word).find())
            return word;

        return word.substring(1) + word.charAt(0) + SUFFIX;
    }
}
