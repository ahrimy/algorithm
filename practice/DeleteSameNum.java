/*
 * 연습문제
 * 같은 숫자는 싫어
 * Java
 */
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int cnt = 0;
        int[] check = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1||arr[i]!=arr[i+1]){
               check[i] = 1;
                cnt++;
            }
        }
        int[] temp = new int[cnt];
        cnt = 0;
                for(int j=0;j<check.length;j++){
                    if(check[j]==1){
                        temp[cnt++] = arr[j];
                    }
                }
        answer = temp;
        return answer;
    }
}