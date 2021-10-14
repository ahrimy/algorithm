/*
 * Summer/Winter Coding(~2018)
 * 기지국 설치
 * Java
 */

public class BaseStation {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int range = 2*w + 1;
        
        int start = 0;
        int end;
        for(int i=0;i<stations.length;i++) {
            end = stations[i] - w - 1;
            answer += (end - start) / range;
            if((end-start)%range > 0) answer++;
            start = stations[i] + w;
        }
        if(start < n) {
            answer += (n - start) / range;
            if((n-start)%range > 0)answer++;
        }

        return answer;
    }
}
