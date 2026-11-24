package code.wars.speed_limit;

import java.util.List;

public class Kata {

    private static final List<SpeedingFine> FINES_TABLE =
            List.of(
                    new SpeedingFine(30, 500),
                    new SpeedingFine(20, 250),
                    new SpeedingFine(10, 100)
            );


    public static int speedLimit(final int speed, final int[] signals) {

        int cumulativeFine = 0;

        for (int signal : signals) {
            int diff = speed - signal;
            if (diff > 0) {
                for (SpeedingFine fineEntry : FINES_TABLE) {
                    if (diff >= fineEntry.aboveLimit) {
                        cumulativeFine += fineEntry.fineValue;
                        break;
                    }
                }
            }
        }
        return cumulativeFine;
    }

    public record SpeedingFine(int aboveLimit, int fineValue) {

    }
}
