public class MinSwaps {


    public  static void main(String... s){
        int[] a = new int[]{2,2,2,2};
        int[] b = new int[]{3,3,3,3};
        int n = a.length;
        int count1 = 0;

        for(int i = 0; i < n-1; i++){
            if(a[i] < a[n-1] && b[i] < b[n-1]) continue;
            if(b[i] < a[n-1] && a[i] < b[n-1]) count1++;
            else{
                count1 = -1;
                System.out.println(count1);
                return;
            }
        }

        int count2 = 1;
        for(int i = 0; i < n-1; i++){
            if(a[i] < b[n-1] && b[i] < a[n-1]) continue;
            if(b[i] < b[n-1] && a[i] < a[n-1]) count2++;
            else{
                count2 = -1;
                System.out.println(count2);
                return;
            }
        }

        int ans = Math.min(count1, count2);
        System.out.println(ans);

    }
}
