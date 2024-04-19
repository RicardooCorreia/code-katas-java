package code.wars.adding_big_numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("1", "1", "2"),
                arguments("01", "01", "2"),
                arguments("123", "456", "579"),
                arguments("888", "222", "1110"),
                arguments("1372", "69", "1441"),
                arguments("12", "456", "468"),
                arguments("100", "101", "201"),
                arguments("63829983432984289347293874", "90938498237058927340892374089", "91002328220491911630239667963")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void basicTests(
            // Givenb
            String a,
            String b,
            String expected) {

        // When
        final String result = Kata.add(a, b);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
