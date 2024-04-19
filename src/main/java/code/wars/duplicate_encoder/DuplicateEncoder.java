package code.wars.duplicate_encoder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateEncoder {

    public static final String NON_DUPLICATED = "(";
    public static final String DUPLICATED = ")";

    static String encode(String word){

        final Map<Integer, String> mapping = new HashMap<>();
        final String lowerCased = word.toLowerCase(Locale.ROOT);
        lowerCased.chars()
                .forEach(letter -> {
                    final String character = mapping.get(letter);
                    if (NON_DUPLICATED.equals(character)) {
                        mapping.put(letter, DUPLICATED);
                    }
                    mapping.putIfAbsent(letter, NON_DUPLICATED);
                });

        return lowerCased.chars()
                .mapToObj(mapping::get)
                .collect(Collectors.joining());
    }
}

