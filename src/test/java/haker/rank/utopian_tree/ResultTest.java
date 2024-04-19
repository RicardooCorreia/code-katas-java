package haker.rank.utopian_tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void utopianTree_whenNoIteration_remainsTheSame() {
        
        // Given
        final int input = 0;

        // When
        final int result = Result.utopianTree(input);


        // Then
        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    void utopianTree_whenOneIteration_thenDoublesTheHeight() {

        // Given
        final int input = 1;

        // When
        final int result = Result.utopianTree(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void utopianTree_whenFourIterations_thenDoublesThenAdds1MeterThenDoublesAndAddsAgain() {

        // Given
        final int input = 4;

        // When
        final int result = Result.utopianTree(input);

        // Then
        assertThat(result)
                .isEqualTo(7);
    }
}