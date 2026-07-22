package code.wars.loneliest_character;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class LoneChar {

    public static char[] loneliest(String s) {

        final var trimedString = s.trim();

        int before = 0, after = 0, max = MIN_VALUE;
        List<Character> lone = new ArrayList<>();
        char current = trimedString.charAt(0);
        for (int i = 1; i < trimedString.length(); i++) {
            final var c = trimedString.charAt(i);
            if (c == ' ') {
                after++;
            } else {
                int currentCount = before + after;
                if (currentCount > max) {
                    max = currentCount;
                    lone.clear();
                    lone.add(current);
                } else if (currentCount == max) {
                    lone.add(current);
                }
                current = c;
                before = after;
                after = 0;
            }
        }

        int currentCount = before + after;
        if (currentCount > max) {
            max = currentCount;
            lone.clear();
            lone.add(current);
        } else if (currentCount == max) {
            lone.add(current);
        }

        return toCharArray(lone);
    }

    private static char[] toCharArray(List<Character> list) {
        final char[] array = new char[list.size()];
        for(int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
