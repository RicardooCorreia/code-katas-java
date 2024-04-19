package code.wars.two_to_one;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoToOneTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("aretheyhere", "yestheyarehere", "aehrsty"),
                arguments("loopingisfunbutdangerous", "lessdangerousthancoding", "abcdefghilnoprstu"),
                arguments("inmanylanguages", "theresapairoffunctions", "acefghilmnoprstuy")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void longest_baseTests(
            // Given
            String string1,
            String string2,
            String expected) {

        // When
        final String result = TwoToOne.longest(string1, string2);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
