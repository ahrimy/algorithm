/**
 * 연습문제
 * 다음 큰 숫자
 * Java
 */

public class NextLargeNumber {
    public int solution(int n) {
        int number = n;
        int count = 0;
        while(number > 0) {
            if(number%2 == 1) count++;
            number/=2;
        }
        
        int nextCount = 0;
        while(nextCount!=count) {
            number = ++n; 
            nextCount = 0;
            while(number > 0) {
                if(number%2 == 1) nextCount++;
                number/=2;
            }
        }
        
        return n;
    }
}
