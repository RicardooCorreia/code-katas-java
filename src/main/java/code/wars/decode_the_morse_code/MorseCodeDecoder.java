package code.wars.decode_the_morse_code;

import java.util.HashMap;

public class MorseCodeDecoder {

    private final static String SPACES_REGEX = "\\s{3}";

    private final static HashMap<String, String> morse = new HashMap<>() {{
        put(".-", "A");
        put("-...", "B");
        put("-.-.", "C");
        put("-..", "D");
        put(".", "E");
        put("..-.", "F");
        put("--.", "G");
        put("....", "H");
        put("..", "I");
        put(".---", "J");
        put("-.-", "K");
        put(".-..", "L");
        put("--", "M");
        put("-.", "N");
        put("---", "O");
        put(".---.", "P");
        put("--.-", "Q");
        put(".-.", "R");
        put("...", "S");
        put("-", "T");
        put("..-", "U");
        put("...-", "V");
        put(".--", "W");
        put("-..-", "X");
        put("-.--", "Y");
        put("--..", "Z");
        put(".----", "1");
        put("..---", "2");
        put("...--", "3");
        put("....-", "4");
        put(".....", "5");
        put("-....", "6");
        put("--...", "7");
        put("---..", "8");
        put("----.", "9");
        put("-----", "0");
        put("--..--", ",");
        put(".-.-.-", ".");
        put("..--..", "?");
    }};

    public static String decode(String morseCode) {

        final String[] words = morseCode.split(SPACES_REGEX);
        final StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            final String[] letters = word.split(" ");
            for (String letter : letters) {
                final String decodedLetter = morse.get(letter);
                if (decodedLetter != null) {
                    stringBuilder.append(decodedLetter);
                }
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
