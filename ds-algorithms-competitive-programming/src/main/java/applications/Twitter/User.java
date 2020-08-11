package applications.Twitter;

import java.util.*;

public class User {
    private List<User> followers;
    Deque<Tweet> newsFeed; //Replicating the behaviour of a Doubly LinkedList
    private int id;
    private static final int LIMIT = 10;

    User(int id) {
        this.id = id;
        this.followers = new ArrayList<>();
        this.newsFeed = new LinkedList<>();
    }

    /**
     * Add a new tweet
     * @param userId
     * @param tweetId
     */
    void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId);
        newsFeed.add(tweet);

        broadcastToFollowers(tweet); //channel-subscriber design pattern
    }


    private void broadcastToFollowers(Tweet tweet) {
        for (User follower : followers) {
            follower.updateNewsFeed(tweet);
        }
    }

    /**
     * Add a new tweet to the feed
     * @param tweet
     */
    public void updateNewsFeed(Tweet tweet) {
        if (newsFeed.size() == LIMIT) {
            this.newsFeed.removeLast();
        }

        this.newsFeed.addFirst(tweet);
    }

    /**
     * Return List top 10 news feed
     * @return
     */
    public List<Integer> getNewsFeedIds() {
        List<Integer> newsFeedIdList = new ArrayList<>();
        for (Tweet tweet : newsFeed) {
            newsFeedIdList.add(tweet.getId());
        }

        return newsFeedIdList;
    }

    /**
     * Add a user to list of followers
     * @param user
     */
    public void addFollower(User user) {
        followers.add(user);
    }

    /**
     * Unfollow the user from the list of user following
     * @param user
     */
    public void unfollow(User user) {
        followers.remove(user);
    }

    /**
     *
     * @return userId of the user
     */
    public int getId() {
        return this.id;
    }

    /**
     * Removes the news feed of a user
     * @param user
     */
    public void removeFeeds(User user) {
        Iterator<Tweet> itr = newsFeed.iterator();
        int userId = user.getId();

        while (itr.hasNext()) {
            Tweet tweet = itr.next();
            if(tweet.getUserId() == userId) itr.remove();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
