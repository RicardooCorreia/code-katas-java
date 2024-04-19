package haker.rank.funny_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static haker.rank.funny_string.Result.FUNNY;
import static haker.rank.funny_string.Result.NOT_FUNNY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ResultTest {

    public static Stream<Arguments> funnyStrings() {

        return Stream.of(
                arguments("lmnop"),
                arguments("acxz")
        );
    }

    public static Stream<Arguments> notFunnyStrings() {

        return Stream.of(
                arguments("bcxz")
        );
    }

    @ParameterizedTest
    @MethodSource("funnyStrings")
    void funnyString_whenIsFunny_returnFunny(
            // Given
            String string
    ) {

        // When
        final String result = Result.funnyString(string);

        // Then
        assertThat(result)
                .isEqualTo(FUNNY);
    }

    @ParameterizedTest
    @MethodSource("notFunnyStrings")
    void funnyString_whenIsNotFunny_returnNotFunny(
            // Given
            String string
    ) {

        // When
        final String result = Result.funnyString(string);

        // Then
        assertThat(result)
                .isEqualTo(NOT_FUNNY);
    }
}