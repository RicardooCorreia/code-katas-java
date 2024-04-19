package code.wars.lucky_tickets;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LuckyTicketTest {

    private final LuckyTicket subject = new LuckyTicket();

    @Test
    public void numberOfTickets_baseTest() {

        // Given
        int from = 100000;
        int to = 999999;

        // When
        int result = subject.numberOfTickets(from, to);

        // Then
        int expected = 50412;
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    public void numberOfTickets_whenOddLength_returnCorrect() {

        // Given
        int from = 1000000;
        int to = 9999999;

        // When
        int result = subject.numberOfTickets(from, to);

        // Then
        int expected = 411048;
        assertThat(result)
                .isEqualTo(expected);
    }
}
