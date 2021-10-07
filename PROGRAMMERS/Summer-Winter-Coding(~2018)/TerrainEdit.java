/*
 * Summer/Winter Coding(~2018)
 * 지형 편집
 * Java
 */
import java.util.Arrays;

public class TerrainEdit {
    public long solution(int[][] land, int P, int Q) {
        long[] arr = new long[land.length * land[0].length];
        long blocks = 0;
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                arr[i*land[0].length + j] = land[i][j];
                blocks += land[i][j];
            }
        }
        Arrays.sort(arr);
        long answer = P > Q ? P*blocks : Q*blocks;
        long min;
        long prev = 0;
        
        for(int i=0;i<arr.length;i++){
            min = ((arr[i] * i) - prev) * P + ((blocks-prev) - arr[i] * (arr.length - i)) * Q;
            if(min < answer) answer = min;
            prev += arr[i];
        }
        
        return answer;
    }
}