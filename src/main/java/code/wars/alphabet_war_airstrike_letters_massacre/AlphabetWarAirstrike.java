package code.wars.alphabet_war_airstrike_letters_massacre;

import java.util.Map;

import static java.util.Map.entry;

public class AlphabetWarAirstrike {

    private static final Map<Character, Integer> STRENGTHS = Map.ofEntries(
            entry('w', -4),
            entry('p', -3),
            entry('b', -2),
            entry('s', -1),
            entry('m', 4),
            entry('q', 3),
            entry('d', 2),
            entry('z', 1)
    );

    public static String alphabetWar(String fight) {

        StringBuilder stringBuilder = getAftermatchString(fight);

        int aftermatch = stringBuilder.chars()
                .mapToObj(codePoint -> (char) codePoint)
                .mapToInt(key -> STRENGTHS.getOrDefault(key, 0))
                .sum();

        if (aftermatch > 0) {
            return "Right side wins!";
        } else if (aftermatch < 0) {
            return "Left side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    private static StringBuilder getAftermatchString(String fight) {

        StringBuilder stringBuilder = new StringBuilder(fight);
        char[] charArray = fight.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '*') { // bomb
                if (i > 0) {
                    stringBuilder.setCharAt(i - 1, '_');
                }
                if (i < fight.length() - 1) {
                    stringBuilder.setCharAt(i + 1, '_');
                }
                stringBuilder.setCharAt(i, '_');
            }
        }
        return stringBuilder;
    }
}
