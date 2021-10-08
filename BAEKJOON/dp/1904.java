package dp;

import java.io.*;

class _1904 {
    public static final int mod = 15746;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            bw.write("1\n");
            bw.close();
            return;
        }
        dp = new int[n+1];
        dp[1] = 1%mod;
        dp[2] = 2%mod;
        fibonacci(n);

        bw.write(dp[n]+"\n");
        bw.close();
    }
    public static void fibonacci(int n){
        if(dp[n] > 0){
            return;
        }
        if(dp[n-1] == 0){
            fibonacci(n-1);
        }
        if(dp[n-2] == 0){
            fibonacci(n-2);
        }
        dp[n] = (dp[n-1] + dp[n-2]) % mod;
    }
}
