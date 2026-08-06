package code.wars.area_of_an_arrow;

import static code.wars.area_of_an_arrow.Solution.arrowArea;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
        "4, 2, 2",
        "7, 6, 10.5",
        "25, 25, 156.25"
    })
    void should_returnCorrectArea_when_givenArrowDimensions(
        // given
        int a, int b, double expected) {

        // when
        double result = arrowArea(a, b);

        // then
        assertThat(result).isEqualTo(expected, within(1e-10));
    }
}