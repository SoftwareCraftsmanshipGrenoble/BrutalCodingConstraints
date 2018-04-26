package ttt;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStateTest {


    @Test
    public void shoud_return_no_winner_after_init()  {
        GameState game = new GameState();
        assertThat(game.winner()).isEqualTo(Player.NONE);
    }

    @Test
    public void shoud_return_no_winner_after_one_shot()  {
        GameState game = new GameState();
        game = game.play(Case.UN);
        assertThat(game.winner()).isEqualTo(Player.NONE);
    }

    @Test
    public void final_test()  {
        GameState game = new GameState();
        game = game.play(Case.UN);
        game = game.play(Case.DEUX);
        game = game.play(Case.QUATRE);
        game = game.play(Case.TROIS);
        game = game.play(Case.SEPT);

        assertThat(game.winner()).isEqualTo(Player.X);
    }
}
