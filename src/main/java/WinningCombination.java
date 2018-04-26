import java.util.List;

import static java.util.Arrays.asList;

public class WinningCombination {

    private final List<Position> positions;

    public WinningCombination(Position first, Position second, Position third) {
        positions = asList(first, second, third);
    }

    public boolean containsPosition(Position position) {
        return positions.contains(position);
    }
}
