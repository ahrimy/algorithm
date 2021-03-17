import java.io.*;
import java.util.*;

class _2565 {
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        int[][] line = new int[n+1][2];
        dp = new int[n+1];

        StringTokenizer st = null;
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2){
                return t1[0] - t2[0];
            }
        });

        int max = 1;
        for(int i=1;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(line[i][1] > line[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }

        System.out.println(n-max);
    }
}
