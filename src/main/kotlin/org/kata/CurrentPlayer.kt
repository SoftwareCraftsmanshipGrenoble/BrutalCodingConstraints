package org.kata

class CurrentPlayer(val player: Player) {
    var players = arrayOf(Player.X, Player.O)

    fun next(): CurrentPlayer {
        return CurrentPlayer(players.filter { it != player }[0])
    }
}