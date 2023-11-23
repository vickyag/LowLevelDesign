import java.util.*;

public class GameManager {
    private final GameBoard gameBoard;
    private final Map<Player, Integer> players;
    private final int noOfDice;

    public GameManager(GameBoard gameBoard, List<Player> players, int noOfDice) {
        this.gameBoard = gameBoard;
        this.noOfDice = noOfDice;
        this.players = new HashMap<>();
        for(Player player: players){
            this.players.put(player, 0);
        }
    }

    private boolean hasWon(Player player){
        return players.get(player) == gameBoard.getSize();
    }

    private int getFinalPosition(int currentPosition){
        while(gameBoard.getLadders().containsKey(currentPosition))
            currentPosition = gameBoard.getLadders().get(currentPosition).getTo();
        while(gameBoard.getSnakes().containsKey(currentPosition))
            currentPosition = gameBoard.getSnakes().get(currentPosition).getTo();
        return currentPosition;
    }

    private int rollDice(){
        int diceSum = 0;
        Random random = new Random();
        for(int i = 0; i < noOfDice; i++){
            diceSum += (random.nextInt(6) + 1);
        }
        return diceSum;
    }

    private void movePlayer(Player player, int diceSum){
        int currentPosition = players.get(player);
        int newPosition = currentPosition + diceSum;
        if(newPosition > gameBoard.getSize()) return;
        newPosition = getFinalPosition(newPosition);
        players.put(player, newPosition);
    }

    public void start() {
        Iterator<Player> playerItr;
        boolean hasWon = false;
        while (!hasWon) {
            playerItr = players.keySet().iterator();
            while (playerItr.hasNext()) {
                Player player = playerItr.next();
                int diceSum = rollDice();
                System.out.println(player.getName() + " rolls the dice and gets " + diceSum);

                int startPosition = players.get(player);
                movePlayer(player, diceSum);
                int finalPosition = players.get(player);
                System.out.println(player.getName() + " moves from " + startPosition + " to " + finalPosition);

                if (hasWon(player)) {
                    hasWon = true;
                    System.out.println(player.getName() + " has won, game is over");
                    break;
                }
            }
        }
    }
}
