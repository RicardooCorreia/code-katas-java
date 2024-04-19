package code.wars.more_zeros_than_ones;

import java.util.HashSet;
import java.util.Set;

public class Kata {

    public static char[] moreZeros(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> addedChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            String binary = Integer.toBinaryString(c);
            long zeroCount = binary.chars()
                    .filter(value -> value - 48 == 0)
                    .count();
            if (zeroCount > binary.length() / 2 && !addedChars.contains(c)) {
                stringBuilder.append(c);
                addedChars.add(c);
            }
        }

        return stringBuilder.toString().toCharArray();
    }
}
