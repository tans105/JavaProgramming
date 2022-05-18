package applications.tictactoe.service;

import applications.tictactoe.pojo.Game;
import applications.tictactoe.pojo.User;

public class UserServiceImpl implements UserService {

    @Override
    public Game register(String u1, String u2) {
        User user1 = new User(u1, 1);
        User user2 = new User(u2, 2);

        User[] players = new User[2];
        players[0] = user1;
        players[1] = user2;

        return new Game(players, 3);
    }
}
