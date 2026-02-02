package code.wars.dude_my_computer_cannot_count;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class VisitorStatistics {
    private final AtomicLong counter = new AtomicLong(0);
    private final Map<String, Long> visitorCount = new ConcurrentHashMap<>();

    public void visit(String name) {

        counter.incrementAndGet();
        visitorCount.compute(name, (_, value) -> value == null ? 1L : value + 1);
    }

    public long totalVisits() {
        return counter.get();
    }

    public long visitsBy(String name) {
        return visitorCount.getOrDefault(name, 0L);
    }
}
