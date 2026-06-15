package code.wars.FollowThatSpy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.String.join;

public class Routes {

    public String findRoutes(String[][] routes) {

        Map<String, String> routeMap = new HashMap<>();
        Set<String> possibleStart = new HashSet<>();
        Set<String> possibleEnd = new HashSet<>();
        for (String[] route : routes) {
            final String from = route[0];
            final String to = route[1];
            routeMap.put(from, to);
            possibleStart.add(from);
            possibleEnd.add(to);
        }

        possibleStart.removeAll(routeMap.values());
        possibleEnd.removeAll(routeMap.keySet());

        String start = possibleStart.iterator().next();
        String end = possibleEnd.iterator().next();

        final ArrayList<String> route = new ArrayList<>();
        String current = start;
        do {
            route.add(current);
            current = routeMap.get(current);
        } while (!current.equals(end));

        route.add(end);

        return join(", ", route);
    }
}
