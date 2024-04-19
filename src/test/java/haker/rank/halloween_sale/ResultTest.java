package haker.rank.halloween_sale;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void howManyGames_whenCanBuy6Games_outputs6Games() {

        // Given
        final int baseGamePrice = 20;
        final int discount = 3;
        final int minimumPrice = 6;
        final int wallet = 80;

        // When
        final int gamesCount = Result.howManyGames(baseGamePrice, discount, minimumPrice, wallet);


        // Then
        assertThat(gamesCount)
                .isEqualTo(6);
    }

    @Test
    void howManyGames_whenCanBuy7Games_outputs7Games() {

        // Given
        final int baseGamePrice = 20;
        final int discount = 3;
        final int minimumPrice = 6;
        final int wallet = 85;

        // When
        final int gamesCount = Result.howManyGames(baseGamePrice, discount, minimumPrice, wallet);


        // Then
        assertThat(gamesCount)
                .isEqualTo(7);
    }

    @Test
    void howManyGames_whenCannotBuyAnyGame_buysNone() {

        // Given
        final int baseGamePrice = 20;
        final int discount = 3;
        final int minimumPrice = 6;
        final int wallet = 10;

        // When
        final int gamesCount = Result.howManyGames(baseGamePrice, discount, minimumPrice, wallet);


        // Then
        assertThat(gamesCount)
                .isEqualTo(0);
    }
}