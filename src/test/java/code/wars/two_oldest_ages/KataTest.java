package code.wars.two_oldest_ages;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @ParameterizedTest
    @MethodSource("twoOldestAgesCases")
    void should_returnTwoOldestAges_when_givenArrayOfAges(int[] ages, int[] expected) {
        // given
        // ages and expected from MethodSource

        // when
        int[] result = Kata.twoOldestAges(ages.clone());

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> twoOldestAgesCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 87, 45, 8, 8}, new int[]{45, 87}),
                Arguments.of(new int[]{6, 5, 83, 5, 3, 18}, new int[]{18, 83}),
                Arguments.of(new int[]{6, 5, 83, 83, 3, 18}, new int[]{83, 83})
        );
    }
}
