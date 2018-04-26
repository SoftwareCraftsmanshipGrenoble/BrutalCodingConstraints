import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerPositions {
    public List<Position> positions;

    public PlayerPositions(Position...positions) {
        this.positions = Collections.unmodifiableList(Arrays.asList(positions));
    }

    public boolean containsAll(WinningCombination winningCombination) {
        return positions.stream().map(winningCombination::containsPosition)
                .filter(b -> b)
                .count() == 3L;
    }
}
