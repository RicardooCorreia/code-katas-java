package code.wars.delete_ocurrences_if_more_than_n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EnoughIsEnoughTest {

    @ParameterizedTest
    @MethodSource("deleteNthInputs")
    void should_returnElementsCappedAtNOccurrences_when_arrayContainsDuplicates(
        // given
        int[] input, int maxOccurrences, int[] expected) {

        // when
        int[] result = EnoughIsEnough.deleteNth(input, maxOccurrences);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> deleteNthInputs() {
        return Stream.of(
            Arguments.of(new int[]{20, 37, 20, 21}, 1, new int[]{20, 37, 21}),
            Arguments.of(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3, new int[]{1, 1, 3, 3, 7, 2, 2, 2}),
            Arguments.of(
                new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3,
                new int[]{1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5}),
            Arguments.of(new int[]{1, 1, 1, 1, 1}, 5, new int[]{1, 1, 1, 1, 1}),
            Arguments.of(new int[]{}, 5, new int[]{})
        );
    }
}
