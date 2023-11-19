import java.math.BigInteger;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1, majorElement = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] == majorElement){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majorElement = nums[i];
                count = 1;
            }
        }

        return majorElement;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{2,1,2,3,2,1,2}));
    }
}
