package org.kata

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class TicTacToeTest {

    @Test
    fun player_X_should_play_first() {
        var game = Game()

        game = game.play(Position.MIDDLE_MIDDLE)

        Assertions.assertThat(game.board.playerAt(Position.MIDDLE_MIDDLE)).isEqualTo(Player.X)
    }

    @Test
    fun player_O_should_play_second() {
        var game = Game()

        game = game.play(Position.MIDDLE_MIDDLE).play(Position.TOP_LEFT)

        Assertions.assertThat(game.board.playerAt(Position.MIDDLE_MIDDLE)).isEqualTo(Player.X)
        Assertions.assertThat(game.board.playerAt(Position.TOP_LEFT)).isEqualTo(Player.O)
    }

    @Test
    fun new_game_should_be_ongoing() {
        var game = Game()

        Assertions.assertThat(game.status()).isEqualTo(GameStatus.ONGOING)
    }

    @Test
    fun x_is_the_winner() {
        var game = Game()

        game = game.play(Position.TOP_LEFT).
                    play(Position.BOTTOM_LEFT).
                    play(Position.TOP_MIDDLE).
                    play(Position.BOTTOM_MIDDLE).
                    play(Position.TOP_RIGHT)

        Assertions.assertThat(game.status()).isEqualTo(GameStatus.X_WINNER)
    }


}