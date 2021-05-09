/**
 * 연습문제
 * 정수 내림차순으로 배치하기
 * Java
 */

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        int length = (int)(Math.log10(n)+1);
        Integer[] number = new Integer[length];
        for(int i=0;i<length;i++){
            number[i] = (int)(n%10);
            n = n/10;
        }
        Arrays.sort(number,Collections.reverseOrder());
        for(int i=0;i<length;i++){
            answer *= 10;
            answer += number[i];
        }
        return answer;
    }
}
