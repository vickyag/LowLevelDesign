import java.util.Random;

public class GenerateRandomInt {

    private static Random random = new Random();
    public static int getRandom(int max){
        return random.nextInt(0, max);
    }

}
