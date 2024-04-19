package code.wars.split_strings;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {

    public static String[] solution(String s) {

        List<String> pairs = new ArrayList<>();
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i = i + 2) {

            char firstChar = s.charAt(i);
            int nextCharIndex = i + 1;
            char secondChar = nextCharIndex < stringLength ? s.charAt(nextCharIndex) : '_';
            pairs.add("" + firstChar + secondChar);
        }

        return pairs.toArray(new String[0]);
    }
}
