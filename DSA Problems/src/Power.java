
public class Power {

    static int pow(int x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n%2 == 1){
            return pow(x, n-1) * x;
        }
        int t = pow(x, n/2);
        return  t * t;
    }

    public static void main(String... s){
        System.out.println(pow(2,-1));
        int i = (int) 1e9;
        System.out.println(i);

    }
}
