package dp;

import java.io.*;

class _1149 {
    public static int[][] dp = new int[1001][3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i < n;i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                min(i+1, j, Integer.parseInt(temp[j]));
            }
        }

        int answer = 1000000; 
        for(int i=0; i<3; i++){
            if(answer > dp[n][i]){
                answer = dp[n][i];
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
    public static void min(int n, int rgb, int cost){
        if(dp[n][rgb] > 0){
            return;
        }
        if(dp[n-1][(rgb+1)%3] > dp[n-1][(rgb+2)%3]){
            dp[n][rgb] = dp[n-1][(rgb+2)%3] + cost;
        }else{
            dp[n][rgb] = dp[n-1][(rgb+1)%3] + cost;
        }
    }
}
