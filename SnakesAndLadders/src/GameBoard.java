import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
    private final int size;
    private final Map<Integer, Snake> snakes;
    private final Map<Integer, Ladder> ladders;

    public GameBoard(int size, List<Snake> snakes, List<Ladder> ladders){
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        for(Snake snake: snakes){
            this.snakes.put(snake.getFrom(), snake);
        }
        for(Ladder ladder: ladders){
            this.ladders.put(ladder.getFrom(), ladder);
        }
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, Snake> getSnakes() {
        return snakes;
    }

    public Map<Integer, Ladder> getLadders() {
        return ladders;
    }
}
