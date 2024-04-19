package haker.rank.acm_icpc_team;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void acmTeam_whenMaximumKnowledgeIs5By2Teams_return5And2() {

        // Given
        final List<String> topics = List.of("10101",
                "11100",
                "11010",
                "00101");

        // When
        final List<Integer> result = Result.acmTeam(topics, 5);

        // Then
        assertThat(result)
                .containsExactly(5, 2);
    }
}