/**
 * 연습문제
 * 최솟값 만들기
 * Java
 */

import java.util.Arrays;

public class MinValue {
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;

        for(int i=0;i<A.length;i++) {
            answer += A[i] * B[B.length-1-i];
        }

        return answer;
    }
}
