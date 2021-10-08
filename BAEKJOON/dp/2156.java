package dp;

import java.io.*;

class _2156 {
    public static long[] dp;
    public static int[] glass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        glass = new int[n + 1];
        dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            glass[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = glass[1];
        long answer = dp[1];
        if (n > 1) {
            dp[2] = glass[1] + glass[2];
            answer = recursive(n);
        }
        bw.write(answer + "\n");
        bw.close();
    }

    public static long recursive(int n) {
        if (dp[n] > 0 || n < 3) {
            return dp[n];
        }
        long[] compare = new long[3];
        compare[0] = glass[n] + glass[n - 1] + recursive(n - 3);
        compare[1] = glass[n] + recursive(n - 2);
        compare[2] = recursive(n - 1);

        long max = 0;
        for (int i = 0; i < 3; i++) {
            if (compare[i] > max) {
                max = compare[i];
            }
        }
        dp[n] = max;
        return dp[n];
    }
}
