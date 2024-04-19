package code.wars.a_simplistic_tcp_finite_state_machine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TCPTest {


    public static Stream<Arguments> states() {

        return Stream.of(
                arguments(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN"}, "CLOSE_WAIT"),
                arguments(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK"}, "ESTABLISHED"),
                arguments(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN", "APP_CLOSE"}, "LAST_ACK"),
                arguments(new String[]{"APP_ACTIVE_OPEN"}, "SYN_SENT"),
                arguments(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK", "APP_CLOSE", "APP_SEND"}, "ERROR")
        );
    }

    @ParameterizedTest
    @MethodSource("states")
    public void traverseStates_calculatesFinalState(
            // Given
            String[] events,
            String expectedFinalState) {

        // When
        final String result = TCP.traverseStates(events);

        // Then
        assertThat(result)
                .isEqualTo(expectedFinalState);
    }
}