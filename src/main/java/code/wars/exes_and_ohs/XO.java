package code.wars.exes_and_ohs;

import java.util.List;

public class XO {

    public static final List<Character> CHARACTERS = List.of('x', 'o', 'X', 'O');

    public static boolean getXO(String str) {

        int count = 0;
        final int result = str.chars()
                .filter(XO::isXorO)
                .reduce(count, (left, right) -> switch (right) {
                    case 'X', 'x' -> left - 1;
                    default -> left + 1;
                });

        return result == 0;
    }

    private static boolean isXorO(int character) {

        return CHARACTERS.contains((char) character);
    }
}
