package dp;
/**
 * 2156
 * 포도주 시식
 * Java
 */

import java.util.Scanner;

public class Wine {
    public static Integer[] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        dp = new Integer[n + 1];
        int[] glasses = new int[n + 1];

        for(int i=1;i<=n;i++) {
            glasses[i] = scan.nextInt();
        }
        scan.close();
        dp[0] = 0;
        dp[1] = glasses[1];
        if(n > 1) dp[2] = glasses[2] + glasses[1];

        System.out.println(calculate(glasses, n));
    }
    public static int calculate(int[] glasses, int n) {
        if(dp[n] != null) return dp[n];

        int firstResult = glasses[n] + calculate(glasses, n - 2);
        int secondResult = glasses[n] + glasses[n-1] + calculate(glasses, n-3);
        int lastResult = calculate(glasses, n - 1);
        dp[n] = Math.max(Math.max(firstResult, secondResult), lastResult);
        return dp[n];
    }
}
