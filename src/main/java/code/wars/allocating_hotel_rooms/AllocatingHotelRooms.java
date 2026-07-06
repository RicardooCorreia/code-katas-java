package code.wars.allocating_hotel_rooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static code.wars.allocating_hotel_rooms.AllocatingHotelRooms.Type.CHECK_IN;
import static code.wars.allocating_hotel_rooms.AllocatingHotelRooms.Type.CHECK_OUT;
import static java.util.Comparator.comparingInt;

public class AllocatingHotelRooms {

    private static final Comparator<Event> EVENT_ORDER =
        comparingInt(Event::time)
        .thenComparingInt(e -> e.type().ordinal());

    public static int[] allocateRooms(int[][] customers) {

        final List<Event> events = new ArrayList<>();
        for (var i = 0; i < customers.length; i++) {
            events.add(new Event(i, customers[i][0], CHECK_IN));
            events.add(new Event(i, customers[i][1], CHECK_OUT));
        }
        events.sort(EVENT_ORDER);

        final var result = new int[customers.length];
        var nextRoom = 0;
        final var freeRooms = new PriorityQueue<Integer>();

        for (var event : events) {
            if (event.type() == CHECK_IN) {
                final var room = freeRooms.isEmpty() ? nextRoom++ : freeRooms.poll();
                result[event.customer()] = room + 1;
            } else {
                freeRooms.add(result[event.customer()] - 1);
            }
        }

        return result;
    }

    private record Event(int customer, int time, Type type) {

    }

    private enum Type {
        CHECK_IN,
        CHECK_OUT,
    }
}