package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DestinationCityTest {

    private final DestinationCity.Solution subject = new DestinationCity.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                arguments(List.of(
                                List.of("London", "New York"),
                                List.of("New York", "Lima"),
                                List.of("Lima", "Sao Paulo")),
                        "Sao Paulo"
                ),
                arguments(List.of(
                                List.of("B", "C"),
                                List.of("D", "B"),
                                List.of("C", "A")),
                        "A"
                ),
                arguments(List.of(List.of("A", "Z")), "Z")
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void destCity(
            // Given
            List<List<String>> paths,
            String expected) {

        // When
        String result = subject.destCity(paths);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}