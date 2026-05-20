package code.wars.berlim_clock;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BerlinClockTest {

    @Test
    void renders_clock_at_12_56_01() {
        var result = BerlinClock.clock("12:56:01");

        assertThat(result).isEqualTo("""
                O
                RROO
                RROO
                YYRYYRYYRYY
                YOOO""");
    }

    @Test
    void renders_clock_at_midnight() {
        var result = BerlinClock.clock("00:00:00");

        assertThat(result).isEqualTo("""
                Y
                OOOO
                OOOO
                OOOOOOOOOOO
                OOOO""");
    }

    @Test
    void renders_clock_at_22_32_45() {
        var result = BerlinClock.clock("22:32:45");

        assertThat(result).isEqualTo("""
                O
                RRRR
                RROO
                YYRYYROOOOO
                YYOO""");
    }
}