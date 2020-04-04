package LeetCode;

public class ZuiChangXIlie {
    /**
     * 最长回文子串  使用二维数组的dp
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int N = s.length();
        int start = 0;
        int len = 1;
        if(N <= 2) return s;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for(int j = 1;j<N;j++){
            for(int i = 0;i<j;i++){
                if (s.charAt(i)==s.charAt(j)) {
                    if(j-i+1 <= 3){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else dp[i][j] = 0;

                if(dp[i][j] == 1){
                    if(j-i+1 > len){
                        start = i;
                        len = j-i+1;
                    }
                }
            }
        }
        return s.substring(start,start+len);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
