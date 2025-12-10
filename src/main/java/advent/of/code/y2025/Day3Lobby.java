package advent.of.code.y2025;

import java.util.Arrays;

public class Day3Lobby {

    public int outputVoltage(String input) {

        Integer[][] batteries = Arrays.stream(input.split("\n"))
                .map(s -> Arrays.stream(s.split(""))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        int voltage = 0;
        for (int line = 0; line < batteries.length; line++) {
            voltage += getLineMaxVoltage(voltage, batteries[line]);
        }
        return voltage;
    }

    private static int getLineMaxVoltage(int voltage, Integer[] batteries) {
        int max = -1;
        int secondMax = -1;
        for (int column = 0; column < batteries.length; column++) {
            Integer battery = batteries[column];
            if (battery > max && column < batteries.length - 1) {
                max = battery;
                secondMax = -1;
            } else if (battery > secondMax) {
                secondMax = battery;
            }
        }
        return Integer.parseInt(String.valueOf(max) + secondMax);
    }
}
