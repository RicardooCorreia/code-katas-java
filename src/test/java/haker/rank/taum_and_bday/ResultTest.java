package haker.rank.taum_and_bday;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ResultTest {

    public static Stream<Arguments> notWorthExchangeParams() {

        return Stream.of(
                arguments(10, 10, 1, 1, 1),
                arguments(5, 9, 2, 3, 4)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "notWorthExchangeParams")
    void taumBday_whenNotWorthToConvert_buyAllRespective(
            // Given
            int amountWhite,
            int amountBlack,
            int priceWhite,
            int priceBlack,
            int exchangePrice) {


        // When
        final long result = Result.taumBday(amountBlack, amountWhite, priceBlack, priceWhite, exchangePrice);

        // Then
        assertThat(result)
                .isEqualTo((long) amountBlack * priceBlack + (long) amountWhite * priceWhite);
    }

    @Test
    void tamBay_whenWorthBlackToWhiteConversion_buyAllBlack() {

        // Given
        final int amountWhite = 3;
        final int amountBlack = 6;
        final int priceWhite = 9;
        final int priceBlack = 1;
        final int exchangePrice = 1;


        // When
        final long result = Result.taumBday(amountBlack, amountWhite, priceBlack, priceWhite, exchangePrice);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }

    @Test
    void tamBay_whenWorthWhiteToBlackConversion_buyAllWhite() {

        // Given
        final int amountWhite = 7;
        final int amountBlack = 7;
        final int priceWhite = 4;
        final int priceBlack = 2;
        final int exchangePrice = 1;


        // When
        final long result = Result.taumBday(amountBlack, amountWhite, priceBlack, priceWhite, exchangePrice);

        // Then
        assertThat(result)
                .isEqualTo(35);
    }

    @Test
    void tamBay_whenWorthWhiteToBlackConversion_buyAllWhite2() {

        // Given
        final int amountWhite = 3;
        final int amountBlack = 3;
        final int priceWhite = 1;
        final int priceBlack = 9;
        final int exchangePrice = 2;


        // When
        final long result = Result.taumBday(amountBlack, amountWhite, priceBlack, priceWhite, exchangePrice);

        // Then
        assertThat(result)
                .isEqualTo(12);
    }
}