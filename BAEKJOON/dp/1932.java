package dp;

import java.io.*;

class _1932 {
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        for(int i=1;i <= n;i++){
            String[] temp = br.readLine().split(" ");
            for(int j=1;j<=i;j++){
                if(j == 1){
                    dp[i][j] = dp[i-1][j] + Integer.parseInt(temp[j-1]);
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + Integer.parseInt(temp[j-1]);
                }else{
                    dp[i][j] = (dp[i-1][j]>dp[i-1][j-1]?dp[i-1][j]:dp[i-1][j-1]) + Integer.parseInt(temp[j-1]);
                }
            }
        }
        
        int answer = 0; 
        for(int i=1; i<=n; i++){
            if(answer < dp[n][i]){
                answer = dp[n][i];
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}
