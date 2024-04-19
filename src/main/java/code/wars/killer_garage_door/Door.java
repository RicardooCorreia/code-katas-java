package code.wars.killer_garage_door;

public class Door {

    public static String run(String events) {

        int openingStatus = 0;
        Status previousStatus = Status.FORWARD;
        Status status = Status.PAUSED;
        StringBuilder stringBuilder = new StringBuilder();
        for (char event : events.toCharArray()) {

            if (isButtonPress(event)) {
                if (Status.PAUSED.equals(status)) {
                    if (openingStatus == 0) {
                        status = Status.FORWARD;
                    } else if (openingStatus == 5) {
                        status = Status.BACKWARD;
                    } else {
                        status = previousStatus;
                    }
                } else {
                    previousStatus = status;
                    status = Status.PAUSED;
                }
            } else if (isObstacle(event)) {
                if (Status.FORWARD.equals(status)) {
                    status = Status.BACKWARD;
                } else {
                    status = Status.FORWARD;
                }
            }

            if (Status.FORWARD.equals(status)) {
                if (openingStatus < 5) {
                    openingStatus++;
                } else {
                    status = Status.PAUSED;
                }
            } else if (Status.BACKWARD.equals(status)) {
                if (openingStatus > 0) {
                    openingStatus--;
                } else {
                    status = Status.PAUSED;
                }
            }

            stringBuilder.append(openingStatus);
        }
        return stringBuilder.toString();
    }

    private static boolean isObstacle(char event) {

        return 'O' == event;
    }

    private static boolean isButtonPress(char event) {

        return 'P' == event;
    }

    public enum Status {
        PAUSED,
        FORWARD,
        BACKWARD
    }
}
