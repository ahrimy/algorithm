/**
 * 연습문제
 * 숫자의 표현
 * Java
 */

public class NumberExpression {
    public int solution(int n) {
        int answer = 0;
        int sum;
        int index;
        for(int i=1;i<=n;i++) {
            sum = 0;
            index = i;
            while(sum < n) {
                sum += index++;
            }
            if(sum == n) answer++;
        }
        return answer;
    }
}
