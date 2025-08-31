import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String... s){

        int[] arr1 = new int[]{1,3,2,5,8,7};
        int[] arr2 = Arrays.stream(arr1).filter(item -> item % 2 == 1).toArray();
        for(int i: arr2) System.out.print(i + ", ");
        List<Integer> list1 = new ArrayList<>();
        Arrays.stream(arr1).filter(item -> item % 2 == 1).forEach(list1::add);
        System.out.println("\n" + list1);
        Set<Integer> set = list1.stream().map(item -> item + 1).collect(Collectors.toSet());
        System.out.println("\n" + set);
        int sum = Arrays.stream(arr1).sum();

    }
}
