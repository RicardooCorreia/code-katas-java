package code.wars.take_a_ten_minute_walk;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {

        if (walk.length != 10) {
            return false;
        }

        final Map<Character, Integer> directionStepCounter = new HashMap<>();
        for (char step : walk) {
            directionStepCounter.putIfAbsent(step, 0);
            final Integer count = directionStepCounter.get(step);
            directionStepCounter.put(step, count + 1);
        }

        return Objects.equals(directionStepCounter.get('n'), directionStepCounter.get('s')) &&
                Objects.equals(directionStepCounter.get('w'), directionStepCounter.get('e'));
    }
}