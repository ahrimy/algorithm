/*
 * 2021 카카오 채용연계형 인턴십
 * 표 편집
 * Java
 */

import java.util.Stack;

public class EditTable {
    Stack<Integer> stack;
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeList = new Node[n];
        for(int i=0;i<n;i++){
            nodeList[i] = new Node(i);
        }
        for(int i=1;i<n;i++){
            nodeList[i].prev = nodeList[i-1];
        }
        for(int i=0;i<n-1;i++){
            nodeList[i].next = nodeList[i+1];
        }
        Node target = nodeList[k];
        stack = new Stack<>();
        for(String c : cmd) {
            switch(c.charAt(0)){
                case 'U':
                    target = moveUp(Integer.parseInt(c.split(" ")[1]), target);
                    break;
                case 'D':
                    target = moveDown(Integer.parseInt(c.split(" ")[1]), target);
                    break;
                case 'C':
                    target = delete(target);
                    break;
                case 'Z':
                    restore(nodeList);
                    break;
            }
        }
        StringBuffer answer = new StringBuffer();
        for(Node node : nodeList){
            answer.append(node.isDeleted ? "X" : "O");
        }
        return answer.toString();
    }
    
    public Node moveUp(int count, Node current){
        Node target = current;
        for(int i=0;i<count;i++){
            target = target.prev;
        }
        return target;
    }
    public Node moveDown(int count, Node current){
        Node target = current;
        for(int i=0;i<count;i++){
            target = target.next;
        }
        return target;
    }
    public Node delete(Node current){
        current.isDeleted = true;
        stack.push(current.idx);
        Node prev = current.prev;
        Node next = current.next;
        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;
        return next == null ? prev : next;
    }
    public void restore(Node[] nodeList){
        int idx = stack.pop();
        Node target = nodeList[idx];
        // 나중에 지워진 항목이 먼저 복원되기 때문에 지워진 항목의 prev, next 는 유지됨
        Node prev = target.prev;
        Node next = target.next;
        if(prev != null) prev.next = target;
        if(next != null) next.prev = target;
        target.isDeleted = false;
    }
    
    class Node {
        int idx;
        Node prev;
        Node next;
        boolean isDeleted;
        
        public Node(int idx) {
            this.idx = idx;
            prev = null;
            next = null;
            isDeleted = false;
        }
    }
}
