/*
 * 탐욕법(Greedy)
 * 큰 수 만들기
 * Java
 */

public class GetLargeNumber {
    public String solution(String number, int k) {
        int remove = k;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<number.length();i++) {
            while(!stack.isEmpty() && stack.peek() < number.charAt(i) && remove > 0) {
                stack.pop();
                remove--;
            }
            stack.push(number.charAt(i));
        }
       
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString().substring(0, number.length()-k);
    }
}
