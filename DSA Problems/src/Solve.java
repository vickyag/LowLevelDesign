import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solve {


    public static void main(String... arg) {

        Map<Character, Integer> freq = new HashMap<>();
        String s = "anellena";
        int k = 3;
        int countOdd = 0;

        for (char c : s.toCharArray()) {
            if (!freq.containsKey(c)) freq.put(c, 0);
            freq.put(c, freq.get(c) + 1);
        }

        for (char c : freq.keySet()) {
            if (freq.get(c) % 2 == 1) countOdd++;
        }
        System.out.println(countOdd <= k);
    }


}