/**
 * 연습문제
 * 하샤드 수
 * Java
 */

public class HarshadNumber {
    public boolean solution(int x) {
        int sumOfNumber = 0;
        int num = x;
        while(num > 0) {
            sumOfNumber += num % 10;
            num /= 10;
        }
        return x % sumOfNumber == 0;
    }
}
