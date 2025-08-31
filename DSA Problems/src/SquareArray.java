
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
// Example 1:
// Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100] Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
public class SquareArray {
    private static int[] squareArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = 0;
        int[] squared = new int[n];
        int sqIdx = 0;
        while(r < n && arr[r] < 0){
            r++;
        }
        l = r-1;

        while(l >= 0 && r < n){
            int sqLeft = arr[l] * arr[l];
            int sqRight = arr[r] * arr[r];
            if(sqLeft < sqRight){
                squared[sqIdx] = sqLeft;
                l--;
            } else {
                squared[sqIdx] = sqRight;
                r++;
            }
            sqIdx++;
        }

        while (l >= 0){
            int sqLeft = arr[l] * arr[l];
            squared[sqIdx++] = sqLeft;
            l--;
        }

        while (r < n){
            int sqRight = arr[r] * arr[r];
            squared[sqIdx++] = sqRight;
            r++;
        }

        return squared;
    }

    public static void main(String... s){
        int[] ans = squareArray(new int[]{1,2,4});
        for(int i: ans) System.out.println(i);
    }

}
