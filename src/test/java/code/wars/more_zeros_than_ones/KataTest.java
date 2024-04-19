package code.wars.more_zeros_than_ones;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
//                Arguments.arguments("abcde", new char[]{'a', 'b', 'd'}),
                Arguments.arguments("thequickbrownfoxjumpsoverthelazydog", new char[]{'h', 'b', 'p', 'a', 'd'}),
                Arguments.arguments("THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG",
                                    new char[]{'T', 'H', 'E', 'Q', 'I', 'C', 'B', 'R', 'F', 'X', 'J', 'P', 'L', 'A', 'D'}),
                Arguments.arguments("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_",
                                    new char[]{'a', 'b', 'd', 'h', 'p', 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J', 'L', 'P', 'Q', 'R', 'T', 'X', '0'}),
                Arguments.arguments("DIGEST", new char[]{'D', 'I', 'E', 'T'})
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void moreZeros_baseTests(
            // Given
            String input,
            char[] expected) {

        // When
        char[] result = Kata.moreZeros(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
