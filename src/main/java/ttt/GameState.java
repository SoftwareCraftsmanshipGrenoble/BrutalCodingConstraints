package ttt;


public class GameState {

    private Player nextPlayer;

    private Board board;

    public GameState() {
        this(Player.X, new Board());
    }

    public GameState(Player nextPlayer, Board board) {
        this.nextPlayer = nextPlayer;
        this.board = board;
    }

    public GameState play(Case aCase) {
        return new GameState(nextPlayer.next(), board.set(nextPlayer, aCase));
    }

    public Player winner() {
        return board.winner();
    }
}
