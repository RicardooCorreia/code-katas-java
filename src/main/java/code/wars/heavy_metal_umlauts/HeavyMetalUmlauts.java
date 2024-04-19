package code.wars.heavy_metal_umlauts;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class HeavyMetalUmlauts {

    private static final Map<String, String> MAPPING = Map.ofEntries(
            entry("a", "\u00e4"),
            entry("e", "\u00eb"),
            entry("i", "\u00ef"),
            entry("o", "\u00f6"),
            entry("u", "\u00fc"),
            entry("y", "\u00ff"),
            entry("A", "\u00c4"),
            entry("E", "\u00cb"),
            entry("I", "\u00cf"),
            entry("O", "\u00d6"),
            entry("U", "\u00dc"),
            entry("Y", "\u0178")
    );

    public static String heavyMetalUmlauts(String boringText) {

        return boringText.chars()
                .mapToObj(value -> String.valueOf((char)value))
                .map(s -> MAPPING.getOrDefault(s, s))
                .collect(Collectors.joining());
    }
}
