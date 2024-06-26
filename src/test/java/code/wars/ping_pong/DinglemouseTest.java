package code.wars.ping_pong;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DinglemouseTest {

    @Test
    public void pingPong_whenPingWins_returnPing() {
        // Given
        String noises = "ping-pong-ping-pong-bonk-bing-doof";

        // When
        final String result = Dinglemouse.pingPong(noises);

        // Then
        assertThat(result).isEqualTo("ping");
    }

    @Test
    public void pingPong_whenPongWins_returnPong() {
        // Given
        String noises = "pong-ping-dong-ping-pong-tink-bonk-pong-ping-doof";

        // When
        final String result = Dinglemouse.pingPong(noises);

        // Then
        assertThat(result).isEqualTo("pong");
    }

    @Test
    public void pingPong_whenHaveSamePoints_returnFirstWinner() {

        // Given
        String noises = "pong-ping-bink-ping-pong-donk";

        // When
        final String result = Dinglemouse.pingPong(noises);

        // Then
        assertThat(result).isEqualTo("ping");
    }

    @Test
    public void pingPong_complexGame_returnCorrectResult() {

        // Given
        String noises = "ping-pong-ping-pong-bash-tang-pong-ping-pong-ping-pong-ping-pong-ping-pong-bing-foom-pong-ping-pong-ping-pong-ping-clik";

        // When
        final String result = Dinglemouse.pingPong(noises);

        // Then
        assertThat(result).isEqualTo("pong");
    }
}
