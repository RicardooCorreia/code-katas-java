package code.wars.ping_pong;

public class Dinglemouse {

    public static final String PING = "ping";
    public static final String PONG = "pong";

    public static String pingPong(String sounds) {

        String lastPlay = "";
        String served = null;
        boolean gameGoing = true;
        int pingPoints = 0;
        int pongPoints = 0;

        for (String play : sounds.split("-")) {

            if (isPing(play) || isPong(play)) {
                served = setServed(served, play);
                lastPlay = play;
                gameGoing = true;
            } else {
                if (gameGoing) {
                    if (isPing(lastPlay) && isPong(served)) {
                        pongPoints++;
                    } else if (isPong(lastPlay) && isPing(served)) {
                        pingPoints++;
                    }
                }
                served = null;
                gameGoing = false;
            }
        }

        return resolveWinner(lastPlay, pingPoints, pongPoints);
    }

    private static String setServed(String served, String play) {
        if (served == null) {
            return play;
        }
        return served;
    }

    private static String resolveWinner(String lastPlay, int pingPoints, int pongPoints) {
        if (pingPoints > pongPoints) {
            return PING;
        } else if (pingPoints < pongPoints) {
            return PONG;
        } else {
            return isPing(lastPlay) ? PONG : PING;
        }
    }

    private static boolean isPing(String lastPlay) {
        return PING.equals(lastPlay);
    }

    private static boolean isPong(String lastPlay) {
        return PONG.equals(lastPlay);
    }
}
