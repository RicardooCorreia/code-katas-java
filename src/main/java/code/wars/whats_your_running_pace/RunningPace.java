package code.wars.whats_your_running_pace;

import java.time.Duration;

public class RunningPace {

    public static String calculate(double distance, String time) {

        final long seconds = getTimeInSeconds(time);
        final long paceInSeconds = Double.valueOf(seconds / distance).longValue();
        final Duration pace = Duration.ofSeconds(paceInSeconds);
        return String.format("%d:%02d", pace.toMinutes(), pace.toSecondsPart());
    }

    private static long getTimeInSeconds(String time) {

        final String[] timeParts = time.split(":");
        final Duration duration = Duration.ofMinutes(Integer.parseInt(timeParts[0]))
                .plusSeconds(Integer.parseInt(timeParts[1]));
        return duration.toSeconds();
    }
}
