import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

public class Printer {
    public int solution(int[] priorities, int location) {
    
        Deque<Integer> list = new ArrayDeque<>(); // 출력되는 순서대로 저장
        Queue<Integer> queue = new LinkedList<>(); // 남은 문서
        Stack<Integer> stack = new Stack<>(); // 밀려나는 문서 임시 저장
        
        for(int i=0;i<priorities.length;i++) {
            queue.add(i);
        }
        
        int target;
        while(!queue.isEmpty()) {
            target = queue.poll();
            
            while(!list.isEmpty() && priorities[list.peekLast()] < priorities[target]){
                stack.push(list.pollLast());
            }
            list.add(target);
            while(!stack.isEmpty()){
                queue.add(stack.pop());
            }
        }


        int answer = 0;
        while(!list.isEmpty()) {
            answer++;
            if(list.poll() == location){
                break;    
            }            
        }
        return answer;
    }
}
