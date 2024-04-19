package code.wars.changing_letters;

import java.util.List;

public class Kata {

    private static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');

    public static String swap(String st) {

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : st.toCharArray()) {
            if (VOWELS.contains(c)) {
                stringBuilder.append(Character.toUpperCase(c));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
