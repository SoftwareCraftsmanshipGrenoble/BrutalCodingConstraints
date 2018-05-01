package org.kata


class Game(val board: Board = Board(), val currentPlayer: CurrentPlayer = CurrentPlayer(Player.X)){

    fun play(position: Position): Game {
        val newBoard = board.play(currentPlayer.player, position)
        val nextPlayer = currentPlayer.next()
        return Game(newBoard, nextPlayer)
    }

    fun status(): GameStatus {
        return GameStatus.ONGOING
    }
}