/**
 * 연습문제
 * 올바른 괄호
 * Java
 */
import java.util.Stack;

public class BracketCheck {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        int index = 0;
        char target;
        while(index < s.length()) {
            target = s.charAt(index++);
            if(target == '(') stack.add('(');
            else {
                if(!stack.isEmpty()) stack.pop();
                else {
                    answer = false;
                    break;
                }
            }
        }
        
        if(!stack.isEmpty()) answer = false;
        
        return answer;
    }
}
