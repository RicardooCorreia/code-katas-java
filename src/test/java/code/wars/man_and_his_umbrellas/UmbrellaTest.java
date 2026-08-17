package code.wars.man_and_his_umbrellas;

import static org.assertj.core.api.Assertions.assertThat;

import code.wars.man_and_his_umbrellas.Umbrella.Weather;

import org.junit.jupiter.api.Test;

class UmbrellaTest {

    @Test
    void should_returnZero_when_noRainyWeather() {
        // given
        Weather[] forecast = { Weather.CLOUDY };

        // when
        int result = Umbrella.minUmbrellas(forecast);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void should_returnOne_when_alwaysRainy() {
        // given
        Weather[] forecast = { Weather.RAINY, Weather.RAINY, Weather.RAINY, Weather.RAINY };

        // when
        int result = Umbrella.minUmbrellas(forecast);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void should_returnTwo_when_dryMorningsAndRainyAfternoons() {
        // given
        Weather[] forecast = { Weather.OVERCAST, Weather.RAINY, Weather.CLEAR, Weather.THUNDERSTORMS };

        // when
        int result = Umbrella.minUmbrellas(forecast);

        // then
        assertThat(result).isEqualTo(2);
    }
}