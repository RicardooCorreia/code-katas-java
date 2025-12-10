package advent.of.code.y2025;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day3LobbyPart2 {

    public static final int NUMBER_OF_BATTERIES = 12;

    public long outputVoltage(String input) {

        return Arrays.stream(input.split("\n"))
                .map(Day3LobbyPart2::parseBatteryLine)
                .mapToLong(Day3LobbyPart2::calculateLineMaxVoltage)
                .sum();
    }

    private static Integer[] parseBatteryLine(String s) {
        return Arrays.stream(s.split(""))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static long calculateLineMaxVoltage(Integer[] batteries) {

        int[] maxVoltage = new int[NUMBER_OF_BATTERIES];
        for (int iBattery = 0; iBattery < batteries.length; iBattery++) {
            Integer battery = batteries[iBattery];
            for (int iVoltage = 0; iVoltage < maxVoltage.length; iVoltage++) {
                if (battery > maxVoltage[iVoltage] && hasEnoughNumbersToFillRemainingSlots(batteries, iBattery, iVoltage)) {
                    maxVoltage[iVoltage] = battery;
                    resetNextRightDigits(iVoltage, maxVoltage);
                    break;
                }
            }
        }

        return Long.parseLong(Arrays.stream(maxVoltage)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    private static boolean hasEnoughNumbersToFillRemainingSlots(Integer[] batteries, int iBattery, int iVoltage) {
        return iBattery + (NUMBER_OF_BATTERIES - iVoltage) <= batteries.length;
    }

    private static void resetNextRightDigits(int iVoltage, int[] maxVoltage) {
        for (int i = iVoltage + 1; i < maxVoltage.length; i++) {
            maxVoltage[i] = 0;
        }
    }
}
