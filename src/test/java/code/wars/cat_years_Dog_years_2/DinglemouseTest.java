package code.wars.cat_years_Dog_years_2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.cat_years_Dog_years_2.Dinglemouse.ownedCatAndDog;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DinglemouseTest {

    @ParameterizedTest
    @MethodSource("provideAgesAndExpectedYears")
    void should_returnCorrectCatAndDogYears_when_givenAges(int catAge, int dogAge, int expectedCatYears, int expectedDogYears) {
        // given
        // input from MethodSource

        // when
        int[] result = ownedCatAndDog(catAge, dogAge);

        // then
        assertThat(result)
            .containsExactly(expectedCatYears, expectedDogYears);
    }

    static Stream<Arguments> provideAgesAndExpectedYears() {
        return Stream.of(
            arguments(15, 15, 1, 1),
            arguments(24, 24, 2, 2),
            arguments(56, 64, 10, 10)
        );
    }
}