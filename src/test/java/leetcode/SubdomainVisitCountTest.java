package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubdomainVisitCountTest {

    private final SubdomainVisitCount.Solution subject = new SubdomainVisitCount.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.arguments(new String[]{"9001 discuss.leetcode.com"},
                        List.of("9001 leetcode.com", "9001 discuss.leetcode.com", "9001 com")),
                Arguments.arguments(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"},
                        List.of("901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com", "951 com"))
        );
    }

    @Test
    void subdomainVisits() {

        // Given
        String[] counts = {
                "900 google.com",
                "60 mail.yahoo.com",
                "10 mobile.sports.yahoo.com",
                "40 sports.yahoo.com",
                "300 yahoo.com",
                "10 stackoverflow.com",
                "20 overflow.com",
                "5 com.com",
                "2 en.wikipedia.org",
                "1 m.wikipedia.org",
                "1 mobile.sports",
                "1 google.co.uk"
        };

        // When
        List<String> result = subject.subdomainVisits(counts);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(
                        "1345 com",
                        "900 google.com",
                        "10 stackoverflow.com",
                        "20 overflow.com",
                        "410 yahoo.com",
                        "60 mail.yahoo.com",
                        "10 mobile.sports.yahoo.com",
                        "50 sports.yahoo.com",
                        "5 com.com",
                        "3 org",
                        "3 wikipedia.org",
                        "2 en.wikipedia.org",
                        "1 m.wikipedia.org",
                        "1 mobile.sports",
                        "1 sports",
                        "1 uk",
                        "1 co.uk",
                        "1 google.co.uk"
                );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void subdomainVisits_baseExamples(
        // Given
            String[] input,
        List<String> expected) {

        // When
        List<String> result = subject.subdomainVisits(input);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder(expected.toArray(new String[0]));
    }
}