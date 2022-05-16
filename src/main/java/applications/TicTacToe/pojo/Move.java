package applications.tictactoe.pojo;

public class Move {
    private int user;
    private int x;
    private int y;

    public Move(int user, int x, int y) {
        this.user = user;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Move{" +
                "user=" + user +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
