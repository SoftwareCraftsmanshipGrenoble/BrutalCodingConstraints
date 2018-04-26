import java.util.List;

import static java.util.Arrays.asList;

public class AllWinningCombinations {

    private static final List<WinningCombination> combinations = asList(new WinningCombination(Position.Zero_Zero, Position.Zero_One, Position.Zero_Two),
            new WinningCombination(Position.One_Zero, Position.One_One, Position.One_Two)
    );


    static boolean isWinner(final PlayerPositions spotsOccupiedByPlayer1) {
        return combinations.stream().anyMatch(spotsOccupiedByPlayer1::containsAll);
    }
    static GameResult gameResult(final PlayerPositions spotsOccupiedByPlayer1, PlayerPositions spotsOccupiedByPlayer2) {
        return combinations.stream().anyMatch(spotsOccupiedByPlayer1::containsAll);
    }
}
