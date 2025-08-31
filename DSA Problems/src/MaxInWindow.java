import java.util.Deque;
import java.util.LinkedList;

public class MaxInWindow {

    public static int[] maxWindow(int[] arr, int k){
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[n - k + 1];
        int index = 0;
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        ans[index++] = arr[dq.peekFirst()];
        for(int i = k; i < n; i++){
            int j = i - k;
            if(!dq.isEmpty() && dq.peekFirst() == j) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            ans[index++] = arr[dq.peekFirst()];
        }

        return ans;
    }

    public static void main(String[] s){
        int[] arr = new int[]{10, 7, 3, 0, 11};
        int[] ans = maxWindow(arr, 3);
        for(int i = 0; i < ans.length; i++) System.out.println(ans[i]);
    }
}
