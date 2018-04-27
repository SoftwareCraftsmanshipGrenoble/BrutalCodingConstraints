
/********************************/
/* code to be moved to index.js */
/********************************/
const tokenPlace = {
    topLeft: 0,
    topCenter: 1,
    topRigth: 2,
    middleLeft: 3,
    middleCenter: 4,
    middleRigth: 5,
    bottomLeft: 6,
    bottomCenter: 7,
    bottomRigth: 8
}

const tokenIdentifier = {
    empty: ' ',
    player1: 'x',
    player2: 'o'
}

class GameBoard {
    constructor(board)
    {
        this.board = board || [
            tokenIdentifier.empty, tokenIdentifier.empty, tokenIdentifier.empty,
            tokenIdentifier.empty, tokenIdentifier.empty, tokenIdentifier.empty,
            tokenIdentifier.empty, tokenIdentifier.empty, tokenIdentifier.empty
        ]
    }

    getTokenAt(place) {
        return this.board[place]
    }

    placeToken(place) {
        const newBoard = [
            ...this.board.splice(0, place - 1),
            tokenIdentifier.player1,
            ...this.board.splice(place, this.board.length - 1)
        ]

        return new GameBoard(newBoard);
    }
}

class TicTacToe {
    constructor(gameBoard) {
        this.board = gameBoard || new GameBoard()
    }

    getTokenAt(place) {
        return this.board.getTokenAt(place) 
    }

    placeToken(place) {
        const newBoard = this.board.placeToken(place)

        return new TicTacToe(newBoard)
    }
}

/*************/
/* test code */
/*************/

test('initial state is empty board', () => {
    let game = new TicTacToe()

    expect(game.getTokenAt(tokenPlace.topLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.topCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.topRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.middleLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.bottomLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomRigth)).toBe(tokenIdentifier.empty)
});

test.only('player should be able to place token on board', () => {
    let game = new TicTacToe()

    game = game.placeToken(tokenIdentifier.topLeft)

    expect(game.getTokenAt(tokenPlace.topLeft)).toBe(tokenIdentifier.player1)
    expect(game.getTokenAt(tokenPlace.topCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.topRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.middleLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.bottomLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomRigth)).toBe(tokenIdentifier.empty)

    game = game.placeToken(tokenIdentifier.topCenter)

    expect(game.getTokenAt(tokenPlace.topLeft)).toBe(tokenIdentifier.player1)
    expect(game.getTokenAt(tokenPlace.topCenter)).toBe(tokenIdentifier.player2)
    expect(game.getTokenAt(tokenPlace.topRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.middleLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.bottomLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomRigth)).toBe(tokenIdentifier.empty)
});

test('placing a token on an already used place should produce the same board', () => {
    let game = new TicTacToe()

    game.placeToken(tokenIdentifier.topLeft)

    expect(game.getTokenAt(tokenPlace.topLeft)).toBe(tokenIdentifier.player1)
    expect(game.getTokenAt(tokenPlace.topCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.topRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.middleLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.bottomLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomRigth)).toBe(tokenIdentifier.empty)

    game.placeToken(tokenIdentifier.topLeft)

    expect(game.getTokenAt(tokenPlace.topLeft)).toBe(tokenIdentifier.player1)
    expect(game.getTokenAt(tokenPlace.topCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.topRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.middleLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.middleRigth)).toBe(tokenIdentifier.empty)

    expect(game.getTokenAt(tokenPlace.bottomLeft)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomCenter)).toBe(tokenIdentifier.empty)
    expect(game.getTokenAt(tokenPlace.bottomRigth)).toBe(tokenIdentifier.empty)
});