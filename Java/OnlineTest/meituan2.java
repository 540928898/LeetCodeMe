package OnlineTest;

import java.util.Arrays;
import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        String[] line = scanner.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        System.out.println(longestSub(arr));
    }

    public static int longestSub(int[] arr){
        int max = Integer.MIN_VALUE;
        int[] brr = new int[arr.length-1];
        for (int i = 0; i < brr.length; i++) {
            int index = 0;
            for (int j = 0; j < arr.length ; j++) {
                if(i == j) continue;
                brr[index++]=arr[j];

            }
            max = Math.max(max,longest(brr));
        }
        return max;
    }

    public static int longest(int[] arr){
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= arr.length ; i++) {
            for (int j = i-1; j >=1; j--) {
                if(arr[i-1]>arr[j-1]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }else break;
            }
            max = Math.max(max,dp[i]);
        }
        return  max;
    }
}
