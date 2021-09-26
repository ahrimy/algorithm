/**
 * 동적계획법(Dynamic Programming)
 * 정수 삼각형
 * Java
 */

public class IntegerTriangle {
    public int[][] dp;
    public int[][] triangle;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        this.triangle = triangle;
        int answer = 0;
        int result = 0;
        for(int i=0;i<triangle.length;i++) {
            result = getMax(triangle.length-1, i);
            if(result > answer) answer = result;
        }
        return answer;
    }
    public int getMax(int x, int y) {
        if(dp[x][y] != 0) {
            return dp[x][y];
        }
        int left = 0;
        int right = 0;
        if(y > 0) left = getMax(x-1, y-1);
        if(x > y) right = getMax(x-1, y);
        dp[x][y] = left > right ? left + triangle[x][y] : right + triangle[x][y];
        return dp[x][y];
    }
}
