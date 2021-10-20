/**
 * 월간 코드 챌린지 시즌 2
 * 괄호 회전하기
 * Java
 */

import java.util.Stack;

public class RotateBracket {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++) {
            if(isCorrect(s.substring(i) + s.substring(0, i))) answer++;
        }
        return answer;
    }
    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') stack.add(s.charAt(i));
            else {
                if(stack.isEmpty()) return false;
                char target = stack.pop();
                if(s.charAt(i) == ']' && target != '[') return false;
                else if(s.charAt(i) == '}' && target != '{') return false;
                else if(s.charAt(i) == ')' && target != '(') return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
