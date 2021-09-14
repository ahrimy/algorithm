/**
 * 연습문제
 * 124 나라의 숫자
 * Java
 */
import java.util.ArrayList;

class Number124 {
    public String solution(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while(n>0){
            n = n-1;
            numbers.add(n%3);
            n = n/3;
        }
        String answer = "";
        for(int i=0; i<numbers.size();i++){
            int temp = (int)Math.pow(2,numbers.get(i));
            answer = String.valueOf(temp)+answer;
        }
        return answer;
    }
}