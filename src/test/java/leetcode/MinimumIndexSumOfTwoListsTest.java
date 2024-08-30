package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumIndexSumOfTwoListsTest {

    private final MinimumIndexSumOfTwoLists.Solution subject = new MinimumIndexSumOfTwoLists.Solution();

    @Test
    void findRestaurant_whenSingleResult_returnCorrect() {

        // Given
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        // When
        String[] result = subject.findRestaurant(list1, list2);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"Shogun"});
    }

    @Test
    void findRestaurant_whenMultipleResultButDifferentIndex_returnCorrect() {

        // Given
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        // When
        String[] result = subject.findRestaurant(list1, list2);

        // Then
        assertThat(result)
                .isEqualTo(new String[]{"Shogun"});
    }

    @Test
    void findRestaurant_whenMultipleResultAndSameIndex_returnMultipleCorrect() {

        // Given
        String[] list1 = {"happy", "sad", "good"};
        String[] list2 = {"sad", "happy", "good"};

        // When
        String[] result = subject.findRestaurant(list1, list2);

        // Then
        assertThat(result)
                .containsExactlyInAnyOrder("sad", "happy");
    }
}