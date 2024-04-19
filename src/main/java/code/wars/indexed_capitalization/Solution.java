package code.wars.indexed_capitalization;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static String capitalize(String s, int[] ind) {

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> indexes = Arrays.stream(ind)
                .boxed()
                .toList();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (indexes.contains(i)) {
                stringBuilder.append(Character.toUpperCase(aChar));
            } else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }
}
