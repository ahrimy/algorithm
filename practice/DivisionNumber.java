/*
 * 연습문제
 * 나누어 떨어지는 숫자 배열
 * Java
 * */

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int value:arr){
            if(value%divisor==0){
                numbers.add(value);
            }
        }
        
        Collections.sort(numbers);
        
        if(numbers.size()==0){
            answer = new int[1];
            answer[0]=-1;
            return answer;
        }
        answer = new int[numbers.size()];
        for(int i=0;i<numbers.size();i++){
            answer[i]=numbers.get(i);
        }
        
        return answer;
    }
}
