package code.wars.complementary_dna;

import java.util.Map;
import java.util.stream.Collectors;

public class DnaStrand {

    private static final Map<Character, Character> mapping = Map.of(
            'A', 'T',
            'T', 'A',
            'C', 'G',
            'G', 'C'
    );

    public static String makeComplement(String dna) {

        return dna.chars()
                .mapToObj(c -> (char) c)
                .map(mapping::get)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
