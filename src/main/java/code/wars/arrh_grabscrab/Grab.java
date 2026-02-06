package code.wars.arrh_grabscrab;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grab {

    public static List<String> grabscrab(String s, List<String> words){

        Map<String, Long> letterPool = buildLetterPool(s);

        return words.stream()
                .map(string -> Map.entry(buildLetterPool(string), string))
                .filter(entry -> entry.getKey().equals(letterPool))
                .map(Map.Entry::getValue)
                .toList();
    }

    private static Map<String, Long> buildLetterPool(String s) {
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(string -> string, Collectors.counting()));
    }
}
