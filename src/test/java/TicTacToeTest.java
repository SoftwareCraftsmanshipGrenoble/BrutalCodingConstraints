import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeTest {



    @Test
    public void empty_board_has_no_winner() {
        PlayerPositions spotsOccupiedByPlayer1 = new PlayerPositions();
        boolean isWinner = isWinner(spotsOccupiedByPlayer1);

        assertThat(isWinner).isFalse();
    }

    @Test
    public void winning_combination_first_row_has_winner() {
        PlayerPositions spotsOccupiedByPlayer1 = new PlayerPositions(Position.Zero_Zero, Position.Zero_One, Position.Zero_Two);
        boolean isWinner = isWinner(spotsOccupiedByPlayer1);

        assertThat(isWinner).isTrue();
    }

    @Test
    public void winning_combination_second_row_has_winner() {
        PlayerPositions spotsOccupiedByPlayer1 = new PlayerPositions(Position.One_Zero, Position.One_One, Position.One_Two);
        boolean isWinner = isWinner(spotsOccupiedByPlayer1);

        assertThat(isWinner).isTrue();
    }


    // spots not in order
    // 4th movement


    private boolean isWinner(PlayerPositions spotsOccupiedByPlayer1) {
        return AllWinningCombinations.isWinner(spotsOccupiedByPlayer1);
    }

    private GameResult isWinner(PlayerPositions spotsOccupiedByPlayer1, PlayerPositions spotsOccupiedByPlayer2) {
        return AllWinningCombinations.gameResult(spotsOccupiedByPlayer1, spotsOccupiedByPlayer2);
    }

}
