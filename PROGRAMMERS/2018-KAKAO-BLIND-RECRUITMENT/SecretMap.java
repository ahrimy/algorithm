/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1차] 비밀지도
 * Java
 */

import java.lang.Math;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0;i<n;i++){
            String result = "";
            int first = arr1[i];
            int second = arr2[i];
            for(int j=n-1;j >= 0;j--){
                int divisor = (int)Math.pow(2,j);
                result += (first/divisor > 0 || second/ divisor > 0) ? "#" : " ";
                first %= divisor;
                second %= divisor;
            }
            answer[i] = result;
        }
        return answer;
    }
}