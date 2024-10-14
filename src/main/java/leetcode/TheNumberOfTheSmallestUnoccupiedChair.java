package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TheNumberOfTheSmallestUnoccupiedChair {

    static class Solution {

        public static final int EMPTY_SEAT = -1;

        public int smallestChair(int[][] times, int targetFriend) {

            List<Event> eventList = IntStream.range(0, times.length)
                    .boxed()
                    .flatMap(friend -> Stream.of(
                            new Event(friend, times[friend][0], EventType.ARRIVING),
                            new Event(friend, times[friend][1], EventType.LEAVING)
                    ))
                    .sorted(this::compareEvents)
                    .toList();

            int[] seats = new int[times.length];
            Arrays.fill(seats, EMPTY_SEAT);
            Map<Integer, Integer> seatingMap = new HashMap<>();
            int nextAvailable = 0;

            for (Event event : eventList) {
                switch (event.type) {
                    case ARRIVING -> {
                        if (event.friend == targetFriend) {
                            return nextAvailable;
                        }

                        seats[nextAvailable] = event.friend;
                        seatingMap.put(event.friend, nextAvailable);
                        nextAvailable = getNextAvailable(nextAvailable, seats);
                    }
                    case LEAVING -> {
                        Integer seat = seatingMap.remove(event.friend);
                        seats[seat] = EMPTY_SEAT;
                        nextAvailable = Math.min(nextAvailable, seat);
                    }
                }
            }

            return -1;
        }

        private int compareEvents(Event event1, Event event2) {
            int timeDiff = event1.time - event2.time;
            if (timeDiff == 0) {
                return event1.type == EventType.LEAVING ? -1 : 1;
            } else {
                return timeDiff;
            }
        }

        private static int getNextAvailable(int nextAvailable, int[] seats) {

            for (int i = nextAvailable + 1; i < seats.length; i++) {
                if (seats[i] == EMPTY_SEAT) {
                    return i;
                }
            }
            return nextAvailable;
        }

        private record Event(int friend, int time, EventType type) {
        }

        private enum EventType {
            ARRIVING, LEAVING
        }
    }
}
