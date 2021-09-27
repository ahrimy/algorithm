/**
 * 그래프
 * 순위
 * Java
 */

public class Rank {
    public int solution(int n, int[][] results) {
        int[][] resultMap = new int[n][n];
        for(int[] result: results) {
            resultMap[result[0]-1][result[1]-1] = 1;
            resultMap[result[1]-1][result[0]-1] = -1;
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(i == j) continue;
                    if(resultMap[i][j] != 0) continue;
                    if(resultMap[i][k] == 1 && resultMap[k][j] == 1) {
                        resultMap[i][j] = 1;
                    }else if(resultMap[i][k] == -1 && resultMap[k][j] == -1) {
                        resultMap[i][j] = -1;
                    }
                }
            }
        }
        int count;
        int answer = 0;
        for(int i=0;i<n;i++) {
            count = 0;
            for(int j=0;j<n;j++) {
                if(resultMap[i][j] != 0) count++;
            }
            if(count == n-1) answer++;
        }
        
        return answer;
    }
}
