package code.wars.find_a_meeting_room;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TheOfficeTest {

    @ParameterizedTest
    @MethodSource("availableRoomCases")
    void should_returnAvailableRoomIndex_when_roomIsFree(char[] rooms, int expectedIndex) {
        // given
        // rooms and expectedIndex from MethodSource

        // when
        Object result = TheOffice.meeting(rooms);

        // then
        assertThat(result).isEqualTo(expectedIndex);
    }

    private static Stream<Arguments> availableRoomCases() {
        return Stream.of(
                Arguments.of(new char[]{'X', 'O', 'X'}, 1),
                Arguments.of(new char[]{'O', 'X', 'X', 'X', 'X'}, 0),
                Arguments.of(new char[]{'X', 'X', 'O', 'X', 'X'}, 2)
        );
    }

    @Test
    void should_returnNoneAvailable_when_allRoomsAreOccupied() {
        // given
        char[] rooms = new char[]{'X', 'X', 'X', 'X', 'X'};

        // when
        Object result = TheOffice.meeting(rooms);

        // then
        assertThat(result).isEqualTo("None available!");
    }
}
