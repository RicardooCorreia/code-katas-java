package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static leetcode.DesignTwitter.Twitter;
import static org.assertj.core.api.Assertions.assertThat;

class DesignTwitterTest {

    @Test
    void designTwitter_completeExample() {

        // Given
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);

        // When
        List<Integer> newsFeed = twitter.getNewsFeed(1);

        // Then
        assertThat(newsFeed)
                .containsExactly(5);

        // And given
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);

        // When
        newsFeed = twitter.getNewsFeed(1);

        // Then
        assertThat(newsFeed)
                .containsExactly(6, 5);

        // And Given
        twitter.unfollow(1, 2);

        // When
        newsFeed = twitter.getNewsFeed(1);

        // Then
        assertThat(newsFeed)
                .containsExactly(5);
    }

    @Test
    void designTwitter_whenFollowingNewPerson_itAddsTheExistingTweets() {

        // Given
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);

        // When
        List<Integer> newsFeed = twitter.getNewsFeed(1);

        // Then
        assertThat(newsFeed)
                .containsExactly(5);

        // And given
        twitter.follow(2, 1);

        // When
        newsFeed = twitter.getNewsFeed(2);

        // Then
        assertThat(newsFeed)
                .containsExactly(5);

        // And Given
        twitter.unfollow(2, 1);

        // When
        newsFeed = twitter.getNewsFeed(2);

        // Then
        assertThat(newsFeed)
                .isEmpty();
    }

    @Test
    void designTwitter_complexExample() {

        // Given
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);

        twitter.unfollow(1, 2);
        twitter.follow(1, 2);

        // When
        List<Integer> newsFeed = twitter.getNewsFeed(1);

        // Then
        assertThat(newsFeed)
                .containsExactly(5, 4);
    }
}