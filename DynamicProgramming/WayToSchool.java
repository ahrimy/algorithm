/**
 * 동적계획법(Dynamic Programming)
 * 등굣길
 * Java
 */

public class WayToSchool {
    int[][] dp;
    boolean[][] puddleMap;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m][n];
        puddleMap = new boolean[m][n];
        for(int[] puddle: puddles) {
            puddleMap[puddle[0]-1][puddle[1]-1] = true;
        }
        if(m > 1 && !puddleMap[1][0]) dp[1][0] = 1;
        if(n > 1 && !puddleMap[0][1]) dp[0][1] = 1;
        
        int answer = search(m-1, n-1);
        return answer;
    }
    public int search(int x, int y) {
        if(dp[x][y] > 0 || puddleMap[x][y]) {
            return dp[x][y];
        }
        if(x > 0) dp[x][y] += search(x-1, y) % 1000000007;
        if(y > 0) dp[x][y] += search(x, y-1) % 1000000007;
        return dp[x][y] % 1000000007;
    }
}
