package applications.tictactoe.pojo;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.List;

public class Game {
    User[] users;
    private List<Move> moves;
    private Board instance;
    private int currentPlayer;

    public Game(User[] users, int dim) {
        this.currentPlayer = 1;
        moves = new ArrayList<>();
        instance = new Board(dim);
        this.users = users;
    }

    public void showBoard() {
        instance.displayBoard();
    }

    public void makeMove(int row, int col) {
        Move move = new Move(this.currentPlayer, row, col);
        if (instance.setMove(move)) {
            moves.add(move);
            if (instance.checkIfOver(move)) {
                showBoard();
                LoggingUtil.logNewLine("Game Over..", "Player", currentPlayer, "wins");
                return;
            }
            if (instance.isTie()) {
                showBoard();
                LoggingUtil.logNewLine("Oops its a Tie");
            }
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
            showBoard();
        }
    }

    public List<Move> getMoves() {
        return moves;
    }
}
