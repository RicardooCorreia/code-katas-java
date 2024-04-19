package code.wars.lucky_tickets;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LuckyTicket {

    public int numberOfTickets(int from, int to) {

        if (from > to) {
            return 0;
        }
        return Math.toIntExact(IntStream.rangeClosed(from, to)
                                       .mapToObj(String::valueOf)
                                       .map(s -> new Parts(s.substring(0, s.length() / 2), s.substring(s.length() / 2)))
                                       .filter(parts -> getSum(parts.left()) == getSum(parts.right()))
                                       .count());
    }

    private static int getSum(String string) {

        return Arrays.stream(string.split(""))
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private record Parts(String left, String right) {

    }
}
