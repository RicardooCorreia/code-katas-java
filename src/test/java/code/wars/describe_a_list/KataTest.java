package code.wars.describe_a_list;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static code.wars.describe_a_list.Kata.describeList;
import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    @Test
    void should_returnEmpty_when_listIsEmpty() {
        // given
        List<?> emptyList = List.of();

        // when
        String result = describeList(emptyList);

        // then
        assertThat(result).isEqualTo("empty");
    }

    @Nested
    class SingletonTests {
        static Stream<List<?>> singletonLists() {
            return Stream.of(List.of(1), List.of(1.5));
        }

        @ParameterizedTest
        @MethodSource("singletonLists")
        void should_returnSingleton_when_listHasOneElement(List<?> input) {
            // given
            // input from MethodSource

            // when
            String result = describeList(input);

            // then
            assertThat(result).isEqualTo("singleton");
        }
    }

    @Nested
    class LongerTests {
        static Stream<List<?>> longerLists() {
            return Stream.of(List.of(1, 2), List.of(1.5, 2.5));
        }

        @ParameterizedTest
        @MethodSource("longerLists")
        void should_returnLonger_when_listHasMultipleElements(List<?> input) {
            // given
            // input from MethodSource

            // when
            String result = describeList(input);

            // then
            assertThat(result).isEqualTo("longer");
        }
    }
}