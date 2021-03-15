import java.io.*;

class _11054{
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        if(n < 3){
            bw.write(n + "\n");
            bw.close();
            return;
        }
        dp = new int[n][2];
        int[] list = new int[n];
        String[] temp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(temp[i]);
        }
        dp[0][0] = 1;
        dp[n-1][1] = 1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(list[j] < list[i] && dp[i][0] < dp[j][0]){
                    dp[i][0] = dp[j][0];
                }
            }
            dp[i][0]++;
        }
        for(int i = n-2; i >= 0; i-- ){
            for(int j=i+1;j<n;j++){
                if(list[j] < list[i] && dp[i][1] < dp[j][1]){
                    dp[i][1] = dp[j][1];
                }
            }
            dp[i][1]++;
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            int sum =  dp[i][0] + dp[i][1];
            if(sum > answer){
                answer = sum;
            }
        }
        bw.write((answer-1)+"\n");
        bw.close();
    }
}