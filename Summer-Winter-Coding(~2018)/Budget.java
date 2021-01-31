/*
 * Summer/Winter Coding(~2018)
 * 예산
 * Java
 */
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int count = 0;
        for(int value: d){
            if(count+value>budget){
                break;
            }
            count += value;
            answer++;
        }
        return answer;
    }
}