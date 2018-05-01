package org.kata

class Board(private val board: HashMap<Position, Player> = HashMap()) {

    fun playerAt(position: Position): Player? {
        return board[position]
    }

    fun play(player: Player, position: Position): Board {
        var newBoard = HashMap<Position, Player>(board)
        newBoard[position] = player
        return Board(newBoard)
    }
}