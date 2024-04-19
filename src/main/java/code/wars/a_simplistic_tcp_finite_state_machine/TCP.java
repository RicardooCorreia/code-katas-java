package code.wars.a_simplistic_tcp_finite_state_machine;

import java.util.Map;
import java.util.Optional;

public class TCP {

    private static final Map<State, Map<Event, State>> STATE_MAPPING = Map.ofEntries(
            Map.entry(State.CLOSED, Map.of(
                    Event.APP_PASSIVE_OPEN, State.LISTEN,
                    Event.APP_ACTIVE_OPEN, State.SYN_SENT)),
            Map.entry(State.LISTEN, Map.of(
                    Event.RCV_SYN, State.SYN_RCVD,
                    Event.APP_SEND, State.SYN_SENT,
                    Event.APP_CLOSE, State.CLOSED)),
            Map.entry(State.SYN_RCVD, Map.of(
                    Event.APP_CLOSE, State.FIN_WAIT_1,
                    Event.RCV_ACK, State.ESTABLISHED)),
            Map.entry(State.SYN_SENT, Map.of(
                    Event.RCV_SYN, State.SYN_RCVD,
                    Event.RCV_SYN_ACK, State.ESTABLISHED,
                    Event.APP_CLOSE, State.CLOSED)),
            Map.entry(State.ESTABLISHED, Map.of(
                    Event.APP_CLOSE, State.FIN_WAIT_1,
                    Event.RCV_FIN, State.CLOSE_WAIT)),
            Map.entry(State.FIN_WAIT_1, Map.of(
                    Event.RCV_FIN, State.CLOSING,
                    Event.RCV_FIN_ACK, State.TIME_WAIT,
                    Event.RCV_ACK, State.FIN_WAIT_2)),
            Map.entry(State.CLOSING, Map.of(
                    Event.RCV_ACK, State.TIME_WAIT)),
            Map.entry(State.FIN_WAIT_2, Map.of(
                    Event.RCV_FIN, State.TIME_WAIT)),
            Map.entry(State.TIME_WAIT, Map.of(
                    Event.APP_TIMEOUT, State.CLOSED)),
            Map.entry(State.CLOSE_WAIT, Map.of(
                    Event.APP_CLOSE, State.LAST_ACK)),
            Map.entry(State.LAST_ACK, Map.of(Event.RCV_ACK, State.CLOSED))
    );


    public static String traverseStates(String[] events) {

        State state = State.CLOSED;
        for (String stringEvent : events) {
            final Event event = Event.valueOf(stringEvent);
            state = getNextState(state, event);
            if (state == State.ERROR) {
                break;
            }
        }

        return state.name();
    }

    private static State getNextState(State state, Event event) {

        final Map<Event, State> eventStateMap = STATE_MAPPING.get(state);
        return Optional.ofNullable(eventStateMap.get(event))
                .orElse(State.ERROR);
    }

    public enum State {
        CLOSED,
        LISTEN,
        SYN_SENT,
        SYN_RCVD,
        ESTABLISHED,
        CLOSE_WAIT,
        LAST_ACK,
        FIN_WAIT_1,
        FIN_WAIT_2,
        CLOSING,
        TIME_WAIT,
        ERROR
    }

    public enum Event {
        APP_PASSIVE_OPEN,
        APP_ACTIVE_OPEN,
        APP_SEND,
        APP_CLOSE,
        APP_TIMEOUT,
        RCV_SYN,
        RCV_ACK,
        RCV_SYN_ACK,
        RCV_FIN,
        RCV_FIN_ACK
    }
}
