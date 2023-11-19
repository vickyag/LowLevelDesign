public class LongestPalindrome {
    public static String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = s.substring(0,1);
        for(int i = 0; i < n; i++) dp[i][i] = true;
        for(int len = 2; len <= n; len++){
            for(int left = 0; left <= n - len; left++){
                int right = left + len - 1;
                if(len == 2 ) dp[left][right] = (s.charAt(left) == s.charAt(right));
                else dp[left][right] = dp[left + 1][right - 1] && (s.charAt(left) == s.charAt(right));
                if(dp[left][right]) ans = s.substring(left, right + 1);
            }
        }
        return ans;
    }

    public static void main(String[] s){
        System.out.println(longestPalindrome("ababac"));
    }
}