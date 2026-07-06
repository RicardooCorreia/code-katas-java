package code.wars.allocating_hotel_rooms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.allocating_hotel_rooms.AllocatingHotelRooms.allocateRooms;
import static java.lang.Math.max;
import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

class AllocatingHotelRoomsTest {

    @ParameterizedTest
    @MethodSource("allocationCases")
    void should_produceValidAllocation_when_allocatingRooms(int[][] customers, int roomsNeeded) {
        // given
        // input from MethodSource

        // when
        var result = allocateRooms(deepCopy(customers));

        // then
        assertThat(isValidAllocation(customers, result, roomsNeeded))
                .as(validationMessage(customers, result, roomsNeeded))
                .isTrue();
    }

    private static Stream<Arguments> allocationCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 4}, {4, 4}}, 2),
                Arguments.of(new int[][]{{1, 5}, {2, 4}, {6, 8}, {7, 7}}, 2),
                Arguments.of(new int[][]{{15, 22}, {2, 4}, {6, 9}, {3, 33}, {12, 21}}, 3),
                Arguments.of(new int[][]{{1, 10}, {2, 5}, {6, 6}, {3, 7}, {6, 6}, {11, 13}, {9, 15}, {8, 14}}, 4),
                Arguments.of(new int[][]{{8, 8}, {5, 8}, {8, 9}, {1, 4}, {1, 3}, {5, 7}, {4, 8}, {2, 2}, {4, 5}, {6, 8}}, 5),
                Arguments.of(new int[][]{{5, 100}}, 1),
                Arguments.of(new int[][]{{15, 19}, {1, 2}, {3, 5}, {10, 10}, {6, 9}, {20, 99}, {101, 101}}, 1),
                Arguments.of(new int[][]{{4, 7}, {1, 10}, {2, 5}, {3, 4}, {3, 12}}, 5)
        );
    }

    private static boolean isValidAllocation(int[][] customers, int[] allocation, int roomsNeeded) {
        return validationMessage(customers, allocation, roomsNeeded).isEmpty();
    }

    private static String validationMessage(int[][] customers, int[] allocation, int roomsNeeded) {
        if (allocation.length != customers.length) {
            return "Wrong number of room assignments: expected " + customers.length + ", got " + allocation.length;
        }

        var maxRoom = 0;
        for (var room : allocation) {
            if (room < 1) {
                return "Room number must be >= 1, got " + room;
            }
            maxRoom = max(maxRoom, room);
        }

        if (maxRoom != roomsNeeded) {
            return "Expected " + roomsNeeded + " rooms, got " + maxRoom;
        }

        for (int i = 0; i < customers.length; i++) {
            for (int j = i + 1; j < customers.length; j++) {
                if (allocation[i] == allocation[j] && overlap(customers[i], customers[j])) {
                    return "Customers " + i + " and " + j + " overlap but share room " + allocation[i];
                }
            }
        }

        return "";
    }

    private static boolean overlap(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }

    private static int[][] deepCopy(int[][] arr) {
        return stream(arr).map(int[]::clone).toArray(int[][]::new);
    }
}