package code.wars.ghostbusters;

public class Ghostbusters {

    public static String ghostBusters(String building) {

        final String noGhosts = building.replaceAll("\s+", "");

        if (building.equals(noGhosts)) {
            return "You just wanted my autograph didn't you?";
        } else {
            return noGhosts;
        }
    }
}
