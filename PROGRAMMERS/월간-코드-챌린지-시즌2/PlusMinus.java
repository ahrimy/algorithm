/**
 * 월간 코드 챌린지 시즌 2
 * 움영 더하기
 * Java
 */

public class PlusMinus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i<absolutes.length;i++) {
            if(signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
}
