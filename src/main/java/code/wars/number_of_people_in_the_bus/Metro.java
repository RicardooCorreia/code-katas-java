package code.wars.number_of_people_in_the_bus;

import java.util.ArrayList;

class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {

        int totalPassengers = 0;
        for (int[] stop : stops) {
            totalPassengers += stop[0] - stop[1];
        }
        return totalPassengers;
    }
}
