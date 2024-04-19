package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TimeNeededToBuyTicketsTest {

    private final TimeNeededToBuyTickets.Solution subject = new TimeNeededToBuyTickets.Solution();

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 3, 2}, 2, 6),
                Arguments.arguments(new int[]{5, 1, 1, 1}, 0, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void timeRequiredToBuy(
        // Given
        int[] tickets,
        int targetPerson,
        int expected) {

        // When
        int result = subject.timeRequiredToBuy(tickets, targetPerson);
        int result2 = subject.timeRequiredToBuy2(tickets, targetPerson);

        // Then
        assertThat(result)
                .isEqualTo(expected)
                .isEqualTo(result2);
    }
}