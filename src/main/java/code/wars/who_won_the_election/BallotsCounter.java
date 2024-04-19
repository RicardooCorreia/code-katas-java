package code.wars.who_won_the_election;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BallotsCounter {

    public static String getWinner(final List<String> listOfBallots) {

        final Map.Entry<String, Long> entry = listOfBallots.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(o -> o.getValue().intValue()))
                .orElseThrow();

        if (entry.getValue() > listOfBallots.size() / 2) {
            return entry.getKey();
        }
        return null;
    }
}
