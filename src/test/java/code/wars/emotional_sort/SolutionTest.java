package code.wars.emotional_sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("descendingOrderCases")
    void should_sortInDescendingOrder_when_descendingIsTrue(String[] input, String[] expected) {
        // given
        boolean descendingOrder = true;

        // when
        String[] actual = Solution.sortEmotions(descendingOrder, input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("ascendingOrderCases")
    void should_sortInAscendingOrder_when_descendingIsFalse(String[] input, String[] expected) {
        // given
        boolean descendingOrder = false;

        // when
        String[] actual = Solution.sortEmotions(descendingOrder, input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void should_returnEmptyArray_when_inputIsEmpty(boolean descendingOrder) {
        // given
        String[] input = new String[]{};

        // when
        String[] actual = Solution.sortEmotions(descendingOrder, input);

        // then
        assertThat(actual).isEmpty();
    }

    static Stream<Arguments> descendingOrderCases() {
        return Stream.of(
            Arguments.of(new String[]{":D", "T_T", ":D", ":("}, new String[]{":D", ":D", ":(", "T_T"}),
            Arguments.of(new String[]{"T_T", ":D", ":(", ":("}, new String[]{":D", ":(", ":(", "T_T"}),
            Arguments.of(new String[]{":)", "T_T", ":)", ":D", ":D"}, new String[]{":D", ":D", ":)", ":)", "T_T"})
        );
    }

    static Stream<Arguments> ascendingOrderCases() {
        return Stream.of(
            Arguments.of(new String[]{":D", "T_T", ":D", ":("}, new String[]{"T_T", ":(", ":D", ":D"}),
            Arguments.of(new String[]{"T_T", ":D", ":(", ":("}, new String[]{"T_T", ":(", ":(", ":D"}),
            Arguments.of(new String[]{":)", "T_T", ":)", ":D", ":D"}, new String[]{"T_T", ":)", ":)", ":D", ":D"})
        );
    }
}