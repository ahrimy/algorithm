/*
 * Weekly Challenge
 * 7주차
 * Java
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class Week7 {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        Queue<Integer> enterQueue = new LinkedList<>();
        Queue<Integer> leaveQueue = new LinkedList<>();
        for(int i=0;i<enter.length;i++) {
            enterQueue.add(enter[i]);
            leaveQueue.add(leave[i]);
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(enterQueue.poll());
        while(!enterQueue.isEmpty()) {
            while(leaveQueue.peek()!=null && set.contains(leaveQueue.peek())) {
                set.remove(leaveQueue.poll());
            }
            for(int num: set) {
                answer[num-1]++;
            }
            answer[enterQueue.peek()-1] = set.size();
            set.add(enterQueue.poll());
        }
        return answer;
    }
}
