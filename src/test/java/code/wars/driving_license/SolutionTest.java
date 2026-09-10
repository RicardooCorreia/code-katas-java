package code.wars.driving_license;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.driving_license.Solution.driver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    public static Stream<Arguments> validPersonData() {
        return Stream.of(
            arguments(new String[]{"John", "James", "Smith", "01-Jan-2000", "M"}, "SMITH001010JJ9AA"),
            arguments(new String[]{"Johanna", "", "Gibbs", "13-Dec-1981", "F"}, "GIBBS862131J99AA"),
            arguments(new String[]{"Andrew", "Robert", "Lee", "02-September-1981", "M"}, "LEE99809021AR9AA")
        );
    }

    @ParameterizedTest
    @MethodSource("validPersonData")
    void should_returnCorrectLicense_when_validPersonDataProvided(String[] person, String expected) {
        // given - input from MethodSource

        // when
        String result = driver(person);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
