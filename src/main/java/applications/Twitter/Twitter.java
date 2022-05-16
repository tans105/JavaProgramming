package applications.twitter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter {
    /**
     * Initialize your data structure here.
     */
    Map<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.postTweet(userId, tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        User user = users.getOrDefault(userId, new User(userId));
        return user.getNewsFeedIds();
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        followee.addFollower(follower);

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        followee.unfollow(follower);
        follower.removeFeeds(followee);
    }

    public User getUser(int userId) {
        User user = users.getOrDefault(userId, new User(userId));
        users.put(userId, user);
        return user;
    }
}
