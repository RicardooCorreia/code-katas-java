package code.wars.mexican_wave;

import java.util.ArrayList;
import java.util.List;

public class MexicanWave {

    public static String[] wave(String str) {

        final char[] chars = str.toCharArray();
        final List<String> variations = calculateVariations(str, chars);
        return variations.toArray(new String[0]);
    }

    private static List<String> calculateVariations(String str, char[] chars) {

        final List<String> variations = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            final char letter = Character.toUpperCase(chars[i]);
            if (letter != ' ') {
                final String variation = createVariation(str, i, letter);
                variations.add(variation);
            }
        }
        return variations;
    }

    private static String createVariation(String str, int i, char letter) {

        return str.substring(0, i) + letter + str.substring(i + 1);
    }
}
