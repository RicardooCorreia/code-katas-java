package leetcode;

import java.util.*;

/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:
    Twitter() Initializes your twitter object.
    void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
    List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
    void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
    void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

Example 1:
    Input
        ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
        [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
    Output
        [null, null, [5], null, null, [6, 5], null, [5]]

Explanation
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
    twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
    twitter.follow(1, 2);    // User 1 follows user 2.
    twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
    twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    twitter.unfollow(1, 2);  // User 1 unfollows user 2.
    twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

Constraints:
    1 <= userId, followerId, followeeId <= 500
    0 <= tweetId <= 104
    All the tweets have unique IDs.
    At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
    A user cannot follow himself.
 */
public class DesignTwitter {

    static class Twitter {

        private final Map<Integer, List<Integer>> followers = new HashMap<>();

        private final Map<Integer, Stack<Integer>> newsFeed = new HashMap<>();

        private final Map<Integer, List<Integer>> tweets = new HashMap<>();

        private final Map<Integer, Long> tweetTimestamp = new HashMap<>();

        public Twitter() {
        }

        public void postTweet(int userId, int tweetId) {

            List<Integer> userTweets = this.tweets.getOrDefault(userId, new ArrayList<>());
            userTweets.add(tweetId);
            this.tweets.put(userId, userTweets);

            tweetTimestamp.put(tweetId, currentTime());

            List<Integer> userFollowers = followers.getOrDefault(userId, new LinkedList<>());
            userFollowers
                    .forEach(follower -> {
                        Stack<Integer> followerFeed = newsFeed.getOrDefault(follower, new Stack<>());
                        followerFeed.push(tweetId);
                        newsFeed.put(follower, followerFeed);
                    });
            Stack<Integer> userNewsFeed = newsFeed.getOrDefault(userId, new Stack<>());
            userNewsFeed.push(tweetId);
            newsFeed.put(userId, userNewsFeed);
        }

        public List<Integer> getNewsFeed(int userId) {

            return newsFeed.getOrDefault(userId, new Stack<>())
                    .reversed()
                    .stream()
                    .limit(10)
                    .toList();
        }

        public void follow(int followerId, int followeeId) {

            List<Integer> userFollowers = this.followers.getOrDefault(followeeId, new LinkedList<>());

            if (userFollowers.contains(followerId) || followerId == followeeId) {
                return;
            }

            userFollowers.add(followerId);
            this.followers.put(followeeId, userFollowers);

            Stack<Integer> followerNewsFeed = newsFeed.getOrDefault(followerId, new Stack<>());
            List<Integer> userTweets = tweets.getOrDefault(followeeId, new LinkedList<>());

            reorderFollowerFeed(followerId, followerNewsFeed, userTweets);
        }

        private void reorderFollowerFeed(int followerId, Stack<Integer> followerNewsFeed, List<Integer> userTweets) {
            int feedIndex = 0, tweetsIndex = 0;
            while (feedIndex < followerNewsFeed.size() && tweetsIndex < userTweets.size()) {
                Integer feedTweet = followerNewsFeed.get(feedIndex);
                Integer newTweet = userTweets.get(tweetsIndex);

                Long feedTweetTime = tweetTimestamp.get(feedTweet);
                Long newTweetTime = tweetTimestamp.get(newTweet);

                if (feedTweetTime > newTweetTime) {
                    feedIndex++;
                } else {
                    followerNewsFeed.add(feedIndex, newTweet);
                    tweetsIndex++;
                }
            }

            if (tweetsIndex < userTweets.size()) {
                followerNewsFeed.addAll(userTweets.subList(tweetsIndex, userTweets.size()));
            }

            newsFeed.put(followerId, followerNewsFeed);
        }

        public void unfollow(int followerId, int followeeId) {

            List<Integer> userFollowers = this.followers.getOrDefault(followeeId, new LinkedList<>());

            if (!userFollowers.contains(followerId) || followerId == followeeId) {
                return;
            }

            userFollowers.remove((Integer) followerId);
            this.followers.put(followeeId, userFollowers);

            Stack<Integer> userNewsFeed = newsFeed.getOrDefault(followerId, new Stack<>());
            List<Integer> tweetsToDelete = tweets.getOrDefault(followeeId, new LinkedList<>());
            tweetsToDelete.forEach(userNewsFeed::remove);
            newsFeed.put(followerId, userNewsFeed);
        }

        private static long currentTime() {
            return System.currentTimeMillis();
        }
    }
}
