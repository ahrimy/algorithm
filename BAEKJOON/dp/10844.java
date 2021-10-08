package dp;

import java.io.*;

class _10844 {
    public static final int mod = 1000000000;
    public static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10];
        for(int i=1;i<10;i++){
            dp[1][i] = 1; 
        }
        long answer = 0;
        for(int i=0;i < 10;i++){
            answer += recursive(n, i);
        }
        answer = answer % mod;
        bw.write(answer+"\n");
        bw.close();
    }
    public static long recursive(int n, int index){
        if(dp[n][index] > 0 || (n < 2 && index < 1)){
            return dp[n][index] % mod;
        }
        long a = 0;
        long b = 0;
        if(index > 0){
            a = recursive(n-1, index-1);
        }
        if(index < 9){
            b = recursive(n-1, index+1);
        }
        dp[n][index] = a + b;
        return dp[n][index] % mod;
    }
}
