package code.wars.mumbling;

import java.util.stream.IntStream;

public class Accumul {

    public static String accum(String s) {

        final char[] chars = s.toCharArray();
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            final char charAt = Character.toLowerCase(chars[i]);
            stringBuilder.append(Character.toUpperCase(charAt));
            IntStream.rangeClosed(1, i)
                    .mapToObj(value -> charAt)
                    .forEach(stringBuilder::append);
            stringBuilder.append("-");
        }

        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
