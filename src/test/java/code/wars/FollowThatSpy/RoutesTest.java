package code.wars.FollowThatSpy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RoutesTest {

    private static Stream<Arguments> routeTestCases() {
        return Stream.of(
            Arguments.of(
                new String[][]{{"MNL", "TAG"}, {"CEB", "TAC"}, {"TAG", "CEB"}, {"TAC", "BOR"}},
                "MNL, TAG, CEB, TAC, BOR"
            ),
            Arguments.of(
                new String[][]{{"Chicago", "Winnipeg"}, {"Halifax", "Montreal"}, {"Montreal", "Toronto"}, {"Toronto", "Chicago"}, {"Winnipeg", "Seattle"}},
                "Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("routeTestCases")
    void should_returnCorrectRoute_when_givenRoutePairs(String[][] pairs, String expectedRoute) {
        // given
        Routes routes = new Routes();

        // when
        String result = routes.findRoutes(pairs);

        // then
        assertThat(result).isEqualTo(expectedRoute);
    }
}
