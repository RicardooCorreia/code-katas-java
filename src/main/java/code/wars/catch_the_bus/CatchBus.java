package code.wars.catch_the_bus;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class CatchBus {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("h:mm a");

    public static double catchTheBus(final String[] busStringTimes, final String[] boyStringTimes) {

        var busStart = toMinutes(busStringTimes[0]);
        var busEnd = toMinutes(busStringTimes[1]);
        var boyStart = toMinutes(boyStringTimes[0]);
        var boyEnd = toMinutes(boyStringTimes[1]);

        if (boyEnd <= busStart) {
            return 0.0;
        } else if (boyStart >= busEnd) {
            return 100.0;
        }

        var busRange = busEnd - busStart;
        var boyRange = boyEnd - boyStart;
        var totalPoints = (double) busRange * boyRange;

        var alwaysMissStrip = (double) boyRange * max(0, boyStart - busStart);

        var overlapStart = max(boyStart, busStart);
        var overlapEnd = min(boyEnd, busEnd);
        var partialMissTriangle = (overlapEnd - overlapStart) * (boyEnd - (overlapStart + overlapEnd) / 2.0);

        return (alwaysMissStrip + partialMissTriangle) / totalPoints * 100;
    }

    private static int toMinutes(String time) {
        return LocalTime.parse(time, FORMATTER).toSecondOfDay() / 60;
    }
}