package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi]
indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively.
 The locations are given as the number of kilometers due east from the car's initial location.
Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

Example 1:
    Input: trips = [[2,1,5],[3,3,7]], capacity = 4
    Output: false
Example 2:
    Input: trips = [[2,1,5],[3,3,7]], capacity = 5
    Output: true

Constraints:
    1 <= trips.length <= 1000
    trips[i].length == 3
    1 <= numPassengersi <= 100
    0 <= fromi < toi <= 1000
    1 <= capacity <= 105
 */
public class CarPooling {

    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {

            List<CarStop> stops = Arrays.stream(trips)
                    .flatMap(ints -> {
                        CarStop pickup = new CarStop(ints[1], ints[0], false);
                        CarStop dropOff = new CarStop(ints[2], ints[0], true);
                        return Stream.of(pickup, dropOff);
                    })
                    .sorted((carStop1, carStop2) -> {
                        int distance = carStop1.place() - carStop2.place();
                        if (distance == 0) {
                            return carStop1.leaving() ? -1 : 1;
                        } else {
                            return distance;
                        }
                    })
                    .toList();

            int currentCapacity = capacity;
            for (CarStop stop : stops) {
                if (!stop.leaving()) {
                    currentCapacity -= stop.passengers();
                    if (currentCapacity < 0) {
                        return false;
                    }
                } else {
                    currentCapacity += stop.passengers();
                }
            }

            return true;
        }

        record CarStop(int place, int passengers, boolean leaving) {
        }
    }
}
