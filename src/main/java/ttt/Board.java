package ttt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Arrays.fill;
import static ttt.Case.*;

public class Board {

    private Player[] board;

    private List<List<Case>> gagne = asList(
            asList(UN, DEUX, TROIS),
            asList(QUATRE, CINQ, SIX),
            asList(UN, QUATRE, SEPT),
            asList(SEPT, HUIT, NEUF),
            asList(UN, QUATRE, SEPT),
            asList(DEUX, CINQ, HUIT),
            asList(TROIS, SIX, NEUF),
            asList(UN, CINQ, NEUF),
            asList(TROIS, CINQ, SEPT)
    );

    public Board() {
        this(getInitBoard());
    }

    private static Player[] getInitBoard() {
        Player[] players = new Player[10];
        fill(players, Player.NONE);
        return players;
    }

    private Board(Player[] board) {
        this.board = board;
    }


    public Board set(Player player, Case aCase) {
        board[aCase.index()] = player;
        return new Board(board);
    }

    public Player winner() {

        Optional<List<Case>> cases = gagne.stream()
                .filter(x -> isWon(x))
                .findFirst();
        System.out.println("cases="+cases);

        int indexGagnant = cases
                .orElse(Arrays.asList(Case.EMPTY))
                .get(0)
                .index();
        System.out.println("indexGagnant="+indexGagnant);

        return board[indexGagnant];
    }

    private boolean isWon(List<Case> cases) {
        final Player player = board[cases.get(0).index()];
        boolean win = cases.stream()
                .filter(aCase -> board[aCase.index()] == player)
                .count() == 3;
        return win;

    }

}
