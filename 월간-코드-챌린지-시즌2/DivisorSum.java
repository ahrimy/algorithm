/**
 * 월간 코드 챌린지 시즌 2
 * 약수의 개와 덧셈
 * Java
 */

public class DivisorSum {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right;i++) {
            if(isDivisorEven(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }
    public boolean isDivisorEven(int num) {
        int count = 0;
        for(int i=1;i<=num;i++) {
            if(num % i == 0) count++;
        }
        return count%2 == 0;
    }
}
