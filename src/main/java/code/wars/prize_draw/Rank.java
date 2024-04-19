package code.wars.prize_draw;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.IntStream;

public class Rank {

    public static String nthRank(String st, Integer[] we, int n) {

        if (st == null || st.isBlank()) {
            return "No participants";
        }

        String[] names = st.split(",");
        if (n > names.length) {
            return "Not enough participants";
        }

        return IntStream.range(0, names.length)
                .mapToObj(i -> new Participant(names[i], we[i]))
                .map(participant -> Map.entry(participant, calculateScore(participant)))
                .sorted(participantComparator())
                .skip(n - 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .map(Participant::name)
                .orElseThrow();
    }

    private static Comparator<Map.Entry<Participant, Integer>> participantComparator() {

        return (o1, o2) -> {
            int result = o2.getValue() - o1.getValue();
            if (result == 0) {
                return o1.getKey().name().compareTo(o2.getKey().name());
            } else {
                return result;
            }
        };
    }

    private static int calculateScore(Participant participant) {

        String name = participant.name();
        int weight = participant.weight();
        int lettersSum = name.chars()
                .map(Character::toLowerCase)
                .map(letter -> letter - 96)
                .sum();
        return (name.length() + lettersSum) * weight;
    }

    public record Participant(String name, int weight) {

    }
}
