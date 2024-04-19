package haker.rank.library_fine;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ResultTest {

    public static Stream<Arguments> beforeDeadlineDeliveries() {

        return Stream.of(
                arguments(25, 12, 2021, 30, 12, 2021, "Same month"),
                arguments(1, 1, 2021, 2, 1, 2021, "Some month, day difference"),
                arguments(6, 4, 2021, 6, 4, 2021, "Same day"),
                arguments(25, 5, 1970, 2, 10, 1970, "Different month"),
                arguments(10, 10, 2019, 1, 1, 2021, "Different year")
        );
    }

    public static Stream<Arguments> afterDeadlineWithinSameMonth() {

        return Stream.of(
                arguments(31, 12, 2021, 1, 12, 2021, 30 * 15, "Large difference"),
                arguments(31, 12, 2021, 30, 12, 2021, 15, "One day difference")
        );
    }

    public static Stream<Arguments> afterDeadlineWithinSameYear() {

        return Stream.of(
                arguments(25, 12, 2021, 30, 5, 2021, 3500, "Large difference"),
                arguments(1, 11, 2021, 31, 10, 2021, 500, "One day difference"),
                arguments(30, 12, 2019, 30, 1, 2019, 5500, "A whole year"),
                arguments(1, 7, 1014, 2, 1, 1014, 3000, "Half a year")

        );
    }

    public static Stream<Arguments> afterDeadlineDifferentYear() {

        return Stream.of(
                arguments(25, 12, 2021, 30, 11, 2020, "Different year"),
                arguments(19, 4, 2500, 19, 4, 2000, "Same month and day, different year"),
                arguments(1, 1, 2021, 31, 12, 2020, "One day difference")
        );
    }

    @ParameterizedTest
    @MethodSource("beforeDeadlineDeliveries")
    void libraryFine_whenBookReturnedBeforeDeadline_returnNoFine(
            // Given
            int returnDay,
            int returnMonth,
            int returnYear,
            int deadlineDay,
            int deadlineMonth,
            int deadlineYear,
            String description) {

        // When
        final int fine = Result
                .libraryFine(returnDay, returnMonth, returnYear, deadlineDay, deadlineMonth, deadlineYear);

        // Then
        assertThat(fine)
                .as(description)
                .isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("afterDeadlineWithinSameMonth")
    void libraryFine_whenBookReturnedAfterDeadlineButInTheSameMonth_return45TimesTheDays(
            // Given
            int returnDay,
            int returnMonth,
            int returnYear,
            int deadlineDay,
            int deadlineMonth,
            int deadlineYear,
            int expectedResult,
            String description) {

        // When
        final int fine = Result
                .libraryFine(returnDay, returnMonth, returnYear, deadlineDay, deadlineMonth, deadlineYear);

        // Then
        assertThat(fine)
                .as(description)
                .isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("afterDeadlineWithinSameYear")
    void libraryFine_whenBookReturnedAfterDeadlineButInTheSameYear_return500TimesTheDays(
            // Given
            int returnDay,
            int returnMonth,
            int returnYear,
            int deadlineDay,
            int deadlineMonth,
            int deadlineYear,
            int expectedResult,
            String description) {

        // When
        final int fine = Result
                .libraryFine(returnDay, returnMonth, returnYear, deadlineDay, deadlineMonth, deadlineYear);

        // Then
        assertThat(fine)
                .as(description)
                .isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("afterDeadlineDifferentYear")
    void libraryFine_whenBookReturnedAfterDeadlineDifferentYear_returnFixedFine(
            // Given
            int returnDay,
            int returnMonth,
            int returnYear,
            int deadlineDay,
            int deadlineMonth,
            int deadlineYear,
            String description) {

        // When
        final int fine = Result
                .libraryFine(returnDay, returnMonth, returnYear, deadlineDay, deadlineMonth, deadlineYear);

        // Then
        assertThat(fine)
                .as(description)
                .isEqualTo(10000);
    }
}