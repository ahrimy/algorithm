package dp;

import java.io.*;

class _1463 {
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 0;

        int answer = caculate(n); 

        bw.write(answer + "\n");
        bw.close();
    }
    public static int caculate(int n){
        if(dp[n]>0 || n<2){
            return dp[n];
        }
        int min;
        int temp;

        min = caculate(n-1) + 1;

        if(n%3==0){
            temp = caculate(n/3)+1;
            min = temp< min? temp:min;
        }

        if(n%2==0){
            temp = caculate(n/2)+1;
            min = temp < min? temp : min;
        }

        dp[n] = min;
        return dp[n];
    }
    
}
