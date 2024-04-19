package code.wars.complementary_dna;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DnaStrandTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("AAAA", "TTTT"),
                arguments("ATTGC", "TAACG"),
                arguments("GTAT", "CATA")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void makeComplement_baseTests(
            // Given
            String input,
            String expected) {

        // When
        final String result = DnaStrand.makeComplement(input);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}
