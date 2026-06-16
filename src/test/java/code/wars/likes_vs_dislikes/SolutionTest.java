package code.wars.likes_vs_dislikes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static code.wars.likes_vs_dislikes.Button.Dislike;
import static code.wars.likes_vs_dislikes.Button.Like;
import static code.wars.likes_vs_dislikes.Button.Nothing;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("buttonTestCases")
    void should_returnCorrectState_when_pressingButtons(
        // given
        Button[] buttons, Button expected) {

        // when
        Button result = Solution.likeOrDislike(buttons);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> buttonTestCases() {
        return Stream.of(
                Arguments.of(new Button[]{Like}, Like),
                Arguments.of(new Button[]{Like, Like}, Nothing),
                Arguments.of(new Button[]{Like, Dislike}, Dislike),
                Arguments.of(new Button[]{Like, Dislike, Dislike}, Nothing),
                Arguments.of(new Button[0], Nothing),
                Arguments.of(new Button[]{Like, Like, Dislike, Dislike, Like, Like, Dislike, Like}, Like)
        );
    }
}
