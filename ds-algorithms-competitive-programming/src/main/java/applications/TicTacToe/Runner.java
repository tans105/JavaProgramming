package applications.TicTacToe;

import applications.TicTacToe.pojo.Game;
import applications.TicTacToe.service.UserService;
import applications.TicTacToe.service.UserServiceImpl;

public class Runner {
    public static void main(String[] args) {
        String u1 = "Tanmay";
        String u2 = "Ruchi";

        UserService service = new UserServiceImpl();
        Game instance = service.register(u1, u2);

        play(instance);
    }

    private static void play(Game instance) {
        instance.showBoard();
        instance.makeMove(0,0);
        instance.makeMove(0,2);
        instance.makeMove(1,0);
        instance.makeMove(1,2);
        instance.makeMove(2,1);
        instance.makeMove(2,0);
        instance.makeMove(2,2);
        instance.makeMove(0,1);
        instance.makeMove(1,1);

    }
}
