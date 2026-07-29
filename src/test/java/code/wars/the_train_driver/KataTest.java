package code.wars.the_train_driver;

import static code.wars.the_train_driver.Kata.arrivalTime;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class KataTest {

    @Nested
    class PositiveTests {

        @Test
        void should_returnArrivalTime_when_singleDestination() {
            // given
            String[] route = {"Crystalium"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("12:15");
        }

        @Test
        void should_returnArrivalTime_when_multipleDestinations() {
            // given
            String[] route = {"Crystalium", "Skyport", "Oasis"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("17:45");
        }

        @Test
        void should_returnArrivalTime_when_departingLateWrapsPastMidnight() {
            // given
            String[] route = {"Nexus", "Skyport", "Oasis"};
            String departureTime = "21:30";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("09:15");
        }

        @Test
        void should_startFromSkyport_when_firstDestinationIsNexus() {
            // given
            String[] route = {"Nexus"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("14:15");
        }

        @Test
        void should_includeWaitingTime_when_lastLegOfJourney() {
            // given
            String[] route = {"Crystalium", "Oasis"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("13:55");
        }
    }

    @Nested
    class NoDirectConnectionTests {

        @Test
        void should_returnViaSkyport_when_noDirectConnectionFromCrystalium() {
            // given
            String[] route = {"Crystalium", "Nexus"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("18:40");
        }

        @Test
        void should_returnViaSkyport_when_noDirectConnectionFromOasis() {
            // given
            String[] route = {"Oasis", "Nexus"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("20:50");
        }
    }

    @Nested
    class SameCityTests {

        @Test
        void should_waitOneHour_when_nextDestinationIsCurrentCityAtStart() {
            // given
            String[] route = {"Skyport"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("11:00");
        }

        @Test
        void should_waitOneHour_when_nextDestinationIsCurrentCityMidRoute() {
            // given
            String[] route = {"Crystalium", "Crystalium"};
            String departureTime = "10:00";

            // when
            String result = arrivalTime(route, departureTime);

            // then
            assertThat(result).isEqualTo("13:15");
        }
    }

    @Test
    void should_returnDayOffMessage_when_noDestinations() {
        // given
        String[] route = {};
        String departureTime = "12:00";

        // when
        String result = arrivalTime(route, departureTime);

        // then
        assertThat(result).isEqualTo("The Train Driver has the day off");
    }
}