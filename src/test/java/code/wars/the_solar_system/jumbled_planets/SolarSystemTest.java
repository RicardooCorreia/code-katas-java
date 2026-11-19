package code.wars.the_solar_system.jumbled_planets;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolarSystemTest {

    @Test
    void should_annotateBodies_when_mixedSystem() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Mars", "Asteroid", "Venus", "Jupiter", "Asteroid", "Earth", "Pluto"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'<', '>', '>', '<', '>', '<'});
    }

    @Test
    void should_annotateBodies_when_asteroidsBeforePlanets() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Asteroid", "Asteroid", "Asteroid", "Earth", "Jupiter"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'=', '=', '>', '>'});
    }

    @Test
    void should_annotateBodies_when_fullSystem() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Mercury", "Venus", "Earth", "Mars", "Asteroid", "Jupiter", "Saturn", "Uranus",
                "Neptune", "Asteroid", "Pluto"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'>', '>', '<', '<', '>', '<', '<', '<', '<', '>'});
    }

    @Test
    void should_returnEmptyArray_when_noBodies() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void should_returnEmptyArray_when_singleBody() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Earth"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void should_returnLessThan_when_planetSmallerThanLeftPlanet() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Earth", "Mars"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'<'});
    }

    @Test
    void should_returnGreaterThan_when_planetBiggerThanLeftPlanet() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Mars", "Earth"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'>'});
    }

    @Test
    void should_returnLessThan_when_plutoSmallerThanMercury() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Mercury", "Pluto"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'<'});
    }

    @Test
    void should_returnGreaterThan_when_plutoBiggerThanAsteroid() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Asteroid", "Pluto"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'>'});
    }

    @Test
    void should_returnLessThan_when_asteroidFollowsPlanet() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Earth", "Asteroid"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'<'});
    }

    @Test
    void should_returnGreaterThan_when_planetFollowsAsteroid() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Asteroid", "Earth"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'>'});
    }

    @Test
    void should_returnEqual_when_asteroidFollowsAsteroid() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Asteroid", "Asteroid"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'='});
    }

    @Test
    void should_returnEqual_when_asteroidFollowsAsteroidAfterPlanet() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Earth", "Asteroid", "Asteroid"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'<', '='});
    }

    @Test
    void should_returnGreaterThanForEachBody_when_bodiesInAscendingSize() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Asteroid", "Pluto", "Mercury", "Mars", "Venus", "Earth", "Neptune", "Uranus", "Saturn",
                "Jupiter"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'>', '>', '>', '>', '>', '>', '>', '>', '>'});
    }

    @Test
    void should_returnLessThanForEachBody_when_bodiesInDescendingSize() {
        // given
        SolarSystem solarSystem = new SolarSystem();
        String[] bodies = {"Jupiter", "Saturn", "Uranus", "Neptune", "Earth", "Venus", "Mars", "Mercury", "Pluto",
                "Asteroid"};

        // when
        char[] result = solarSystem.annotate(bodies);

        // then
        assertThat(result).isEqualTo(new char[]{'<', '<', '<', '<', '<', '<', '<', '<', '<'});
    }
}
