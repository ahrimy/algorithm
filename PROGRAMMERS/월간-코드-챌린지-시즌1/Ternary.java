/**
 * 월간 코드 챌린지 시즌 1
 * 3진법 뒤집기
 * Java
 */

import java.util.Stack;

public class Ternary {
    public int solution(int n) {

        Stack<Integer> stack = new Stack();
        while(n > 0) {
            stack.add(n % 3);
            n /= 3;
        }
        int answer = 0;
        int index = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop() * Math.pow(3, index++);
        }
        
        return answer;
    }
}
