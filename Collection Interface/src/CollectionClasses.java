import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class CollectionClasses {

    public static void main(String... s){

        int[] arr = new int[5];
        int[][] arr2 = new int[10][];
        Integer[] arr3 = new Integer[1];
        arr[1] = 2;
        int size = arr.length;
        Comparator<Integer> integerComparator = (a1, a2) -> { return a2 - a1;};
        Arrays.sort(arr);
        Arrays.sort(arr3, integerComparator);
        Arrays.asList(arr);

        Object objectArr = arr;
        System.out.println(objectArr instanceof int[]);
        int[] newArr = (int[]) objectArr;
        newArr[0] = 3;
        System.out.println(newArr[0]);

        String str = "ab";
        str.length();
        str.charAt(0);
        StringBuilder str2 = new StringBuilder();
        str2.append('c');
        str2.length();
        str2.charAt(0);


        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        Comparator<String> stringComparator = (s1, s2) -> {
            return s2.compareTo(s1);
        };
        list1.add(1);
        list1.sort(integerComparator);
        list1.remove(Integer.valueOf(1));
        list1.size();
        list1.toArray();
        Collections.sort(list2, stringComparator);
        Collections.synchronizedList(list1);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.peek();
        stack.pop();
        stack.isEmpty();
        stack.iterator();
        stack.size();

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new PriorityQueue<>(integerComparator);
        Queue<Integer> q3 = new LinkedBlockingDeque<>();
        Deque<Integer> dq1 = new LinkedList<>();
        q1.add(1);
        q1.peek();
        q1.poll();
        q1.isEmpty();

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 1);
        String s2 = "test";
        s2.hashCode();

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.contains(1);
        set.remove(1);

    }

}


