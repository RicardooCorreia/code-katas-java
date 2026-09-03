package code.wars.equal_side_of_an_array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class KataTest {

    @ParameterizedTest
    @MethodSource("arraysWithEqualSides")
    void should_returnExpectedIndex_when_equalSidesExist(
        // given
        int[] array, int expectedIndex) {

        // when
        int result = Kata.findEvenIndex(array);

        // then
        assertThat(result).isEqualTo(expectedIndex);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "-8505,-5130,1926,-9026"})
    void should_returnMinusOne_when_noEqualSidesExist(
        // given
        String arrayInput) {
        int[] array = parseArray(arrayInput);

        // when
        int result = Kata.findEvenIndex(array);

        // then
        assertThat(result).isEqualTo(-1);
    }

    private static Stream<Arguments> arraysWithEqualSides() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4, 3, 2, 1}, 3),
                Arguments.of(new int[] {1, 100, 50, -51, 1, 1}, 1),
                Arguments.of(new int[] {20, 10, 30, 10, 10, 15, 35}, 3),
                Arguments.of(new int[] {2824, 1774, -1490, -9084, -9696, 23094}, 1),
                Arguments.of(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}, 6));
    }

    private static int[] parseArray(String input) {
        String[] parts = input.split(",");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        return array;
    }
}
