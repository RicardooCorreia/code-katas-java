package code.wars.oberserved_pin;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObservedPinTest {

    public Stream<Arguments> baseScenarios() {

        return Stream.of(
                arguments("", List.of()),
                arguments("8", List.of("5", "7", "8", "9", "0")),
                arguments("11", List.of("11", "21", "41", "12", "22", "42", "14", "24", "44")),
                arguments("369", List.of("236",
                                         "238",
                                         "239",
                                         "256",
                                         "258",
                                         "259",
                                         "266",
                                         "268",
                                         "269",
                                         "296",
                                         "298",
                                         "299",
                                         "336",
                                         "338",
                                         "339",
                                         "356",
                                         "358",
                                         "359",
                                         "366",
                                         "368",
                                         "369",
                                         "396",
                                         "398",
                                         "399",
                                         "636",
                                         "638",
                                         "639",
                                         "656",
                                         "658",
                                         "659",
                                         "666",
                                         "668",
                                         "669",
                                         "696",
                                         "698",
                                         "699")));
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    public void getPINs_baseTests(
            // Given
            String input,
            List<String> expected) {

        // When
        List<String> result = ObservedPin.getPINs(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrderElementsOf(expected);
    }
}
