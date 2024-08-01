package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfSeniorCitizensTest {

    private final NumberOfSeniorCitizens.Solution subject = new NumberOfSeniorCitizens.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}, 2),
                Arguments.arguments(new String[]{"1313579440F2036", "2921522980M5644"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void countSeniors(
            // Given
            String[] details,
            int expected) {

        // When
        int result = subject.countSeniors(details);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}