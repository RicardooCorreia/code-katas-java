package code.wars.roman_numerals_helper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RomanNumerals {

    private static final TreeMap<Integer, String> INTEGER_TO_ROMAN;

    private static final List<Map.Entry<Integer, String>> ORDERED_BY_SYMBOL_LENGTH_ROMAN_SYMBOLS;

    static {
        INTEGER_TO_ROMAN = new TreeMap<>(Collections.reverseOrder());
        INTEGER_TO_ROMAN.put(1, "I");
        INTEGER_TO_ROMAN.put(4, "IV");
        INTEGER_TO_ROMAN.put(5, "V");
        INTEGER_TO_ROMAN.put(9, "IX");
        INTEGER_TO_ROMAN.put(10, "X");
        INTEGER_TO_ROMAN.put(40, "XL");
        INTEGER_TO_ROMAN.put(50, "L");
        INTEGER_TO_ROMAN.put(90, "XC");
        INTEGER_TO_ROMAN.put(100, "C");
        INTEGER_TO_ROMAN.put(400, "CD");
        INTEGER_TO_ROMAN.put(500, "D");
        INTEGER_TO_ROMAN.put(900, "CM");
        INTEGER_TO_ROMAN.put(1000, "M");
        ORDERED_BY_SYMBOL_LENGTH_ROMAN_SYMBOLS = INTEGER_TO_ROMAN.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().length() - o1.getValue().length()) // Double symbols first
                .collect(Collectors.toList());
    }

    public static int fromRoman(String romanNumeral) {

        int number = 0;
        String currentRomanNumeral = romanNumeral;
        for (Map.Entry<Integer, String> symbol : ORDERED_BY_SYMBOL_LENGTH_ROMAN_SYMBOLS) {
            String romanNumber = symbol.getValue();
            while (currentRomanNumeral.contains(romanNumber)) {
                number += symbol.getKey();
                currentRomanNumeral = currentRomanNumeral.replaceFirst(romanNumber, "");
            }
        }
        return number;
    }

    public static String toRoman(int input) {

        final StringBuilder builder = new StringBuilder();

        int currentNumber = input;
        for (Map.Entry<Integer, String> entry : INTEGER_TO_ROMAN.entrySet()) {

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
