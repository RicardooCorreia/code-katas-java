package code.wars.simple_time_difference;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static String solve(String[] arr) {

        if (arr.length == 1) {
            return "23:59";
        }

        List<Duration> durations = Arrays.stream(arr)
                .map(Solution::getDuration)
                .sorted()
                .toList();

        Duration longestDuration = Duration.ZERO;

        Duration previousDuration = durations.get(0);
        for (int i = 1; i <= durations.size(); i++) {
            int index = i % durations.size();
            Duration currentDuration = durations.get(index);

            if (currentDuration.compareTo(previousDuration) < 0) {
                currentDuration = currentDuration.plusDays(1);
            }

            Duration difference = currentDuration.minus(previousDuration);
            longestDuration = difference.compareTo(longestDuration) > 0 ? difference : longestDuration;

            previousDuration = currentDuration;
        }

        return String.format("%02d:%02d", longestDuration.toHoursPart(), (longestDuration.toMinutesPart() - 1));
    }

    private static Duration getDuration(String string) {
        String[] parts = string.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return Duration.ofHours(hours).plusMinutes(minutes);
    }
}
