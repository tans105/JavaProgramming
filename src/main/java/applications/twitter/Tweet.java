package applications.twitter;

public class Tweet {
    private int id;
    private int userId;

    public Tweet(int userId, int id) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
}
