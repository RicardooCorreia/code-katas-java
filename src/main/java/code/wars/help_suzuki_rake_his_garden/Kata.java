package code.wars.help_suzuki_rake_his_garden;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {

    private static final String GRAVEL = "gravel";
    private static final String ROCK = "rock";
    private static final List<String> ALLOWED = List.of(ROCK, GRAVEL);

    public static String rakeGarden(String garden) {

        return Arrays.stream(garden.split(" "))
                .map(s -> {
                    if (ALLOWED.contains(s)) {
                        return s;
                    } else {
                        return GRAVEL;
                    }
                })
                .collect(Collectors.joining(" "));
    }
}
