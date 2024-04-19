package code.wars.pair_of_shoes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShoeTest {

    @Test
    void pairOfShoes_whenIsOnePair_returnTrue() {

        // Given
        Shoe[] shoes = new Shoe[]{new Shoe(Foot.LEFT, 30), new Shoe(Foot.RIGHT, 30)};

        // When
        boolean result = Solution.pairOfShoes(shoes);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void pairOfShoes_whenIsTwoPairs_returnTrue() {

        // Given
        Shoe[] shoes = new Shoe[]{new Shoe(Foot.LEFT, 30), new Shoe(Foot.RIGHT, 31)};

        // When
        boolean result = Solution.pairOfShoes(shoes);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    void pairOfShoes_whenIsMultiplePairs_returnTrue() {

        // Given
        Shoe[] shoes = new Shoe[]{new Shoe(Foot.LEFT, 30), new Shoe(Foot.RIGHT, 30),
                new Shoe(Foot.LEFT, 36), new Shoe(Foot.RIGHT, 36),
                new Shoe(Foot.LEFT, 42), new Shoe(Foot.RIGHT, 42),};

        // When
        boolean result = Solution.pairOfShoes(shoes);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void pairOfShoes_whenIsMultiplePairsOfTheSameSize_returnTrue() {

        // Given
        Shoe[] shoes = new Shoe[]{new Shoe(Foot.LEFT, 30), new Shoe(Foot.RIGHT, 30),
                new Shoe(Foot.LEFT, 30), new Shoe(Foot.RIGHT, 30)};

        // When
        boolean result = Solution.pairOfShoes(shoes);

        // Then
        assertThat(result)
                .isTrue();
    }

    @Test
    void pairOfShoes_whenHasMissingPairs_returnFalse() {

        // Given
        Shoe[] shoes = new Shoe[]{new Shoe(Foot.LEFT, 31), new Shoe(Foot.RIGHT, 31),
                new Shoe(Foot.LEFT, 30), new Shoe(Foot.LEFT, 30)};

        // When
        boolean result = Solution.pairOfShoes(shoes);

        // Then
        assertThat(result)
                .isFalse();
    }

    @Test
    void pairOfShoes_whenMultipleAreMissing_returnFalse() {

        // Given
        Shoe[] shoes = new Shoe[]{new Shoe(Foot.LEFT, 30), new Shoe(Foot.RIGHT, 30),
                new Shoe(Foot.LEFT, 30), new Shoe(Foot.RIGHT, 30),
                new Shoe(Foot.LEFT, 30), new Shoe(Foot.LEFT, 30)
        };

        // When
        boolean result = Solution.pairOfShoes(shoes);

        // Then
        assertThat(result)
                .isFalse();
    }


    @Test
    void pairOfShoes_whenMissingSamePair_returnFalse() {

        // Given
        Shoe[] shoes = new Shoe[]{new Shoe(Foot.RIGHT, 30), new Shoe(Foot.RIGHT, 30),
                new Shoe(Foot.RIGHT, 30), new Shoe(Foot.LEFT, 30),
                new Shoe(Foot.RIGHT, 30), new Shoe(Foot.LEFT, 30)
        };

        // When
        boolean result = Solution.pairOfShoes(shoes);

        // Then
        assertThat(result)
                .isFalse();
    }
}
