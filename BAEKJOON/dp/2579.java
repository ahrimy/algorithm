package dp;

import java.io.*;

class _2579 {
    public static long[] dp;
    public static int[] stair;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        stair = new int[n+1];
        dp = new long[n+1];
        for(int i=1;i <= n;i++){
           stair[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = stair[1];
        if(n > 1){
            dp[2] = stair[1] + stair[2];
        }
        if(n > 2){
            step(n);
        } 
        bw.write(dp[n] + "\n");
        bw.close();
    }
    public static long step(int n){
        if(dp[n] > 0 || n==0){
            return dp[n];
        }

        long oneStep = step(n-3) + stair[n-1] + stair[n];
        long twoStep = step(n-2) + stair[n];
        dp[n] = oneStep>twoStep ? oneStep:twoStep;

        return dp[n];
    }
}
