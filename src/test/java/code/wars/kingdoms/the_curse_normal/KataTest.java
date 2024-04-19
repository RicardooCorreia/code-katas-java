package code.wars.kingdoms.the_curse_normal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    public static Stream<Arguments> baseScenarios() {

        return Stream.of(
                Arguments.arguments("a**? *c*. **e,",
                                    new String[]{"ace", "acd", "abd"},
                                    "abd? acd. ace,"),
                Arguments.arguments("m** ***e **s l*****",
                                    new String[]{"name", "myy", "legion", "iss"},
                                    "myy name iss legion"),
                Arguments.arguments("*** **** **s *****n, f** **e *r* m***!",
                                    new String[]{"mmy", "name", "iss", "legion", "for", "wwe", "are", "many"},
                                    "mmy name iss legion, for wwe are many!"),
                Arguments.arguments("*** **g *o* never **o **rment m*e!",
                                    new String[]{"demon", "mme", "hell", "spit", "iii", "pigg", "beg", "too", "you", "never", "torment", "exorcism"},
                                    "iii beg you never too torment mme!"),
                Arguments.arguments("***! **ll? f*l*. he*l, fe*l? c*ll. ***t,",
                                    new String[]{"mel", "dell", "felt", "fill", "fell", "hell", "cell"},
                                    "mel! dell? fill. hell, fell? cell. felt,"),
                Arguments.arguments("",
                                    new String[]{"hell", "weak"},
                                    ""),
                Arguments.arguments("****. ***,",
                                    new String[]{"aaa", "bbbb"},
                                    "bbbb. aaa,")
        );
    }

    @ParameterizedTest
    @MethodSource("baseScenarios")
    void translate_baseScenarios(
            // Given
            String speech,
            String[] vocabulary,
            String expected) {

        // When
        String result = Kata.translate(speech, vocabulary);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void newEdge() {

        assertThat(Kata.translate(
                "fye*** w*eg **e ***z* ***s x*e*fg *****v eee*eu i** ***re **g*t* *e*",
                new String[]{"eggete", "fefffv", "eeeeeu", "fyefee", "wfeg", "iee", "eefs", "hee", "hfe", "efere", "gegzf", "xgeffg"}
        )).isEqualTo("fyefee wfeg hfe gegzf eefs xgeffg fefffv eeeeeu iee efere eggete hee");
    }
}
