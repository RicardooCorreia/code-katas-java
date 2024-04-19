package code.wars.roman_numerals_encoder;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Conversion2 {
    
    private static final TreeMap<Integer, String> SYMBOLS;

    static {
        SYMBOLS = new TreeMap<>(Collections.reverseOrder());
        SYMBOLS.put(1, "I");
        SYMBOLS.put(4, "IV");
        SYMBOLS.put(5, "V");
        SYMBOLS.put(9, "IX");
        SYMBOLS.put(10, "X");
        SYMBOLS.put(40, "XL");
        SYMBOLS.put(50, "L");
        SYMBOLS.put(90, "XC");
        SYMBOLS.put(100, "C");
        SYMBOLS.put(400, "CD");
        SYMBOLS.put(500, "D");
        SYMBOLS.put(900, "CM");
        SYMBOLS.put(1000, "M");
    }

    public String solution(int input) {

        final StringBuilder builder = new StringBuilder();

        int currentNumber = input;
        for (Map.Entry<Integer, String> entry : SYMBOLS.entrySet()) {

            final int numberThatHasSymbol = entry.getKey();
            final String symbol = entry.getValue();

            while (currentNumber >= numberThatHasSymbol) {
                builder.append(symbol);
                currentNumber -= numberThatHasSymbol;
            }
        }
        return builder.toString();
    }
}
