package code.wars.shorter_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortestPath {

    public static String[] directions(String[] goal) {

        Map<String, Long> collect = Arrays.stream(goal)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Long nCount = Optional
                .ofNullable(collect.get("N"))
                .orElse(0L);
        Long sCount = Optional
                .ofNullable(collect.get("S"))
                .orElse(0L);

        Long wCount = Optional
                .ofNullable(collect.get("W"))
                .orElse(0L);
        Long eCount = Optional
                .ofNullable(collect.get("E"))
                .orElse(0L);

        long nDeduced = nCount - sCount;
        long wDeduced = wCount - eCount;

        if (nDeduced == 0 && wDeduced == 0) {
            return new String[]{""};
        }

        List<String> result = new ArrayList<>();

        IntStream.range(0, Math.toIntExact(Math.abs(nDeduced)))
                .mapToObj(value -> nDeduced > 0 ? "N" : "S")
                .forEach(result::add);

        IntStream.range(0, Math.toIntExact(Math.abs(wDeduced)))
                .mapToObj(value -> wDeduced > 0 ? "W" : "E")
                .forEach(result::add);

        return result.toArray(value -> new String[0]);
    }
}
