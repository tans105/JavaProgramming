package applications.twitter;

public class Runner {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        //Test Case 1;
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.follow(1, 2);// User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);// User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 1 tweet id -> [5], // since user 1 is no longer following user 2.
        //


        //Test Case 2
        twitter = new Twitter();
        twitter.follow(1, 2);
        twitter.follow(3, 2);
        for (int i = 0; i < 6; i++) {
            twitter.postTweet(2, i);
        }

        for (int i = 6; i < 12; i++) {
            twitter.postTweet(1, i);
        }

        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
        System.out.println(twitter.getNewsFeed(3));
        //

    }
}
