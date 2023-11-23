import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int noOfDice = 2;
        int sizeOfBoard = 100;
        Player[] players = {
                new Player("p1"),
                new Player("p2"),
                new Player("p3")
        };

        Snake[] snakes = {
                new Snake(30, 10),
                new Snake(40, 25),
                new Snake(99, 10),
                new Snake(60, 33),
                new Snake(78, 60)
        };

        Ladder[] ladders = {
                new Ladder(8, 20),
                new Ladder(16, 34),
                new Ladder(50, 92),
                new Ladder(65, 77)
        };

        GameBoard gameBoard = new GameBoard(sizeOfBoard, Arrays.asList(snakes), Arrays.asList(ladders));
        GameManager gameManager = new GameManager(gameBoard, Arrays.asList(players), noOfDice);
        gameManager.start();
    }
}