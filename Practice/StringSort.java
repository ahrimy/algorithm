/**
 * 연습문제
 * 문열 내 마음대로 정렬하기
 * Java
 */

import java.util.Arrays;

public class StringSort {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (a , b) -> {
            if(a.charAt(n) < b.charAt(n)) return -1;
            if(a.charAt(n) > b.charAt(n)) return 1;
            return a.compareTo(b);
        });
            
        return strings;
    }
}
