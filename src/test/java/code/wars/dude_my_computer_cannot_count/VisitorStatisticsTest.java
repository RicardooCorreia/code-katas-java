package code.wars.dude_my_computer_cannot_count;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitorStatisticsTest {

    private VisitorStatistics visitorStatistics;

    @BeforeEach
    void setUp() {
        visitorStatistics = new VisitorStatistics();
    }

    @Test
    void totalVisits_afterMultipleVisits_returnsTotalCount() {
        // Given
        visitorStatistics.visit("A");
        visitorStatistics.visit("B");
        visitorStatistics.visit("A");

        // When
        long total = visitorStatistics.totalVisits();

        // Then
        assertThat(total).isEqualTo(3L);
    }

    @Test
    void visitsBy_whenUserAVisitedTwice_returnsTwo() {
        // Given
        visitorStatistics.visit("A");
        visitorStatistics.visit("B");
        visitorStatistics.visit("A");

        // When
        long countA = visitorStatistics.visitsBy("A");

        // Then
        assertThat(countA).isEqualTo(2L);
    }

    @Test
    void visitsBy_whenUserBVisitedOnce_returnsOne() {
        // Given
        visitorStatistics.visit("A");
        visitorStatistics.visit("B");
        visitorStatistics.visit("A");

        // When
        long countB = visitorStatistics.visitsBy("B");

        // Then
        assertThat(countB).isEqualTo(1L);
    }

    @Test
    void handleConcurrentAccess_whenManyThreadsVisit_sameName_countsAccurate() throws InterruptedException {
        // Given
        CountDownLatch latch = new CountDownLatch(1);
        Thread[] threads = new Thread[1000];
        String name = "Visitor";

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                visitorStatistics.visit(name);
            });
            threads[i].start();
        }

        // When
        latch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }

        // Then
        assertThat(visitorStatistics.totalVisits()).isEqualTo(threads.length);
        assertThat(visitorStatistics.visitsBy(name)).isEqualTo(threads.length);
    }
}
