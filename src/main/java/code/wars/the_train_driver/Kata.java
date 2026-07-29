package code.wars.the_train_driver;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.Duration.ZERO;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;

public class Kata {

    private static final String START = "Skyport";
    private static final Duration WAITING_TIME = Duration.ofHours(1);

    private static final Routes ROUTES = Routes.of(
        new Route("Skyport", "Crystalium", Duration.ofMinutes(15), Duration.ofHours(2)),
        new Route("Crystalium", "Skyport", Duration.ofMinutes(10), Duration.ofHours(2)),
        new Route("Skyport", "Oasis", Duration.ofMinutes(20), Duration.ofHours(3)),
        new Route("Oasis", "Skyport", Duration.ofMinutes(15), Duration.ofHours(3)),
        new Route("Oasis", "Crystalium", Duration.ofMinutes(15), Duration.ofMinutes(90)),
        new Route("Crystalium", "Oasis", Duration.ofMinutes(10), Duration.ofMinutes(90)),
        new Route("Skyport", "Nexus", Duration.ofMinutes(15), Duration.ofHours(4)),
        new Route("Nexus", "Skyport", Duration.ofMinutes(10), Duration.ofHours(4))
    );

    public static String arrivalTime(final String[] route, final String departureTime) {

        if (route.length == 0) {
            return "The Train Driver has the day off";
        }

        Duration tripDuration = ZERO;
        String previousStop = START;
        for (var nextStop : route) {

            if (nextStop.equals(previousStop)) {
                tripDuration = tripDuration.plus(WAITING_TIME);
                continue;
            }

            var trip = ROUTES.get(previousStop, nextStop);

            if (trip == null) {
                final var goBackTrip = ROUTES.get(previousStop, START);
                tripDuration = tripDuration.plus(goBackTrip.standBy()).plus(goBackTrip.duration());
                trip = ROUTES.get(START, nextStop);
            }

            tripDuration = tripDuration.plus(trip.standBy()).plus(trip.duration());
            previousStop = nextStop;
        }

        final var departure = LocalTime.parse(departureTime);
        final var arrivalTime = departure.plus(tripDuration);

        return arrivalTime.toString();
    }

    public static class Routes extends HashMap<String, Route> {

        public Routes(Map<? extends String, ? extends Route> m) {
            super(m);
        }

        public Route get(String origin, String destination) {
            return super.get(routeKey(origin, destination));
        }

        public static Routes of(Route... routes) {
            final var collect = stream(routes)
                .collect(Collectors.toMap(Routes::routeKey, identity()));
            return new Routes(collect);
        }

        public static String routeKey(Route route) {
            return routeKey(route.origin(), route.destination());
        }

        private static String routeKey(String origin, String destination) {
            return origin + ":" + destination;
        }
    }

    public record Route(String origin, String destination, Duration standBy, Duration duration) {

    }
}
