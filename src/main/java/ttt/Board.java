package ttt;

public class Board {

    Player[] board;

    public Board() {
        this(new Player[9]);
    }

    public Board(Player[] board) {
        this.board = board;
    }


    public Board set(Player player, Case aCase) {
        board[aCase.index()] = player;
        return new Board(board);
    }

    public Player winner() {
        if(board[0] == Player.X &&
           board[3] == Player.X &&
           board[6] == Player.X) {
            return Player.X;
        }
        return Player.NONE;
    }
}
