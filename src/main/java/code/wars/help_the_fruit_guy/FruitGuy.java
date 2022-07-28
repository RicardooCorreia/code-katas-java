package code.wars.help_the_fruit_guy;

import java.util.Arrays;
import java.util.Locale;

public class FruitGuy {

    public static String[] removeRotten(String[] fruitBasket) {

        if (fruitBasket == null) return null;

        return Arrays.stream(fruitBasket)
                .map(s -> s.replaceAll("rotten", ""))
                .map(s -> s.toLowerCase(Locale.ROOT))
                .toArray(String[]::new);
    }
}
