
public class ProductExceptItself {
    public static void solve(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            left[i] = left[i-1] * nums[i];
            right[n-i-1] = right[n-i] * nums[n-i-1];
        }
        for(int i = 0; i < n; i++){
            int leftP = i == 0 ? 1 : left[i-1];
            int rightP = i == n-1 ? 1 : right[i+1];
            ans[i] = leftP * rightP;
        }
        for(int val: ans) System.out.print(val + " ");
    }

    public static void main(String... s){
        int[] nums = new int[]{1,2,3,4,5};
        solve(nums);
    }
}
