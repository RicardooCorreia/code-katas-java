package code.wars.bumps_in_the_road;

public class BumpsTheRoad {

    public static String bumps(final String road) {

        return road.chars()
                .mapToObj(value -> (char) value)
                .filter(character -> character == 'n')
                .count() > 15 ? "Car Dead" : "Woohoo!";
    }
}
