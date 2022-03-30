package code.wars.most_frequent_weekdays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments(1770, new String[]{"Monday"}),
                arguments(1785, new String[]{"Saturday"}),
                arguments(1901, new String[]{"Tuesday"}),
                arguments(2135, new String[]{"Saturday"}),
                arguments(3043, new String[]{"Sunday"}),
                arguments(2001, new String[]{"Monday"}),
                arguments(3150, new String[]{"Sunday"}),
                arguments(3230, new String[]{"Tuesday"}),
                arguments(2016, new String[]{"Friday", "Saturday"}),
                arguments(1986, new String[]{"Wednesday"}),
                arguments(3361, new String[]{"Thursday"}),
                arguments(1910, new String[]{"Saturday"}),
                arguments(1968, new String[]{"Monday", "Tuesday"}),
                arguments(1794, new String[]{"Wednesday"}),
                arguments(1984, new String[]{"Monday", "Sunday"}),
                arguments(2000, new String[]{"Saturday", "Sunday"})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void mostFrequentDays_baseScenarios(
            // Given
            int year,
            String[] expected
    ) {

        // When
        final String[] result = Kata.mostFrequentDays(year);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
