package code.wars.berlim_clock;

import static java.lang.Integer.parseInt;
import static java.lang.System.lineSeparator;

public class BerlinClock {

    public static final String YELLOW = "Y";
    public static final String RED = "R";
    public static final String OFF = "O";

    public static String clock(String time) {

        final String[] parts = time.split(":");
        final int hours = parseInt(parts[0]);
        final int minutes = parseInt(parts[1]);
        final int seconds = parseInt(parts[2]);

        final String evenSecondsLight = seconds % 2 == 0 ? YELLOW : OFF;

        final int firstHourRowOnLights = hours / 5;
        final var firstRow = buildHourRow(firstHourRowOnLights);
        final var secondRow = buildHourRow(hours - (firstHourRowOnLights * 5));

        final StringBuilder thirdRow = new StringBuilder();
        final int firstMinutesRowOnLights = minutes / 5;
        int remainingOn = firstMinutesRowOnLights;
        for (int i = 0; i < 11; i++) {
            if (remainingOn > 0) {
                thirdRow.append((i + 1) % 3 == 0 ? RED : YELLOW);
                remainingOn--;
            } else {
                thirdRow.append(OFF);
            }
        }

        final StringBuilder fourthRow = new StringBuilder();
        int remainingMinutes = minutes - (firstMinutesRowOnLights * 5);
        for (int i = 0; i < 4; i++) {
            if (remainingMinutes > 0) {
                fourthRow.append(YELLOW);
                remainingMinutes--;
            } else {
                fourthRow.append(OFF);
            }
        }

        return
            evenSecondsLight + lineSeparator() +
                firstRow + lineSeparator() +
                secondRow + lineSeparator() +
                thirdRow + lineSeparator() +
                fourthRow;
    }

    private static String buildHourRow(int firstRowOn) {

        final var row = new StringBuilder();
        int on = firstRowOn;
        for (int i = 0; i < 4; i++) {
            if (on > 0) {
                row.append(RED);
                on--;
            } else {
                row.append(OFF);
            }
        }
        return row.toString();
    }
}