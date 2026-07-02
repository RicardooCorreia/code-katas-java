package code.wars.minutes_to_midnight;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class MinuteTest {

    @Nested
    class RegularTests {

        @ParameterizedTest
        @CsvSource({"10, 0, 840 minutes", "12, 0, 720 minutes", "18, 30, 330 minutes", "20, 15, 225 minutes"})
        void should_returnCorrectMinutes_when_timeIsBeforeMidnight(int hour, int minute, String expected) {
            // given
            var date = dateAt(hour, minute);

            // when
            var result = new Minute().countMinutes(date);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class EdgeTests {

        @Test
        void should_returnOneMinute_when_oneMinuteBeforeMidnight() {
            // given
            var date = dateAt(23, 59);

            // when
            var result = new Minute().countMinutes(date);

            // then
            assertThat(result).isEqualTo("1 minute");
        }

        @Test
        void should_return1440Minutes_when_midnight() {
            // given
            var date = dateAt(0, 0);

            // when
            var result = new Minute().countMinutes(date);

            // then
            assertThat(result).isEqualTo("1440 minutes");
        }
    }

    @Nested
    class FormattingTests {

        @Test
        void should_useSingularForm_when_exactlyOneMinute() {
            // given
            var date = dateAt(23, 59);

            // when
            var result = new Minute().countMinutes(date);

            // then
            assertThat(result).isEqualTo("1 minute");
        }

        @Test
        void should_usePluralForm_when_moreThanOneMinute() {
            // given
            var date = dateAt(23, 58);

            // when
            var result = new Minute().countMinutes(date);

            // then
            assertThat(result).isEqualTo("2 minutes");
        }
    }

    private static Date dateAt(int hour, int minute) {
        return dateAt(hour, minute, 0);
    }

    private static Date dateAt(int hour, int minute, int second) {
        var calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}