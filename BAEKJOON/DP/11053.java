import java.io.*;

class _11053 {
    public static int[] dp;
    public static int[] sequence;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        if(n < 2){
            bw.write(1 + "\n");
            bw.close();
            return;
        }
        sequence = new int[n];
        dp = new int[n];

        String[] temp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            sequence[i] = Integer.parseInt(temp[i]);
        }

        int answer = 1;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(dp[i] <= dp[j] && sequence[i] > sequence[j]){
                    dp[i] = dp[j] + 1;
                }
            }
            if(answer < dp[i]){
                answer = dp[i];
            }
        }

        bw.write(answer + "\n");
        bw.close();
    }
}
