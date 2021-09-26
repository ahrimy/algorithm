/*
 * Weekly Challenge
 * 7주차
 * Java
 */

import java.util.HashSet;

public class Week7 {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        int enterIndex = 0;
        int leaveIndex = 0;
        HashSet<Integer> set = new HashSet<>();
        while(enterIndex < enter.length) {
            while(leaveIndex < leave.length && set.contains(leave[leaveIndex])) {
                set.remove(leave[leaveIndex++]);
            }
            for(int num: set) {
                answer[num-1]++;
            }
            answer[enter[enterIndex]-1] = set.size();
            set.add(enter[enterIndex++]);
        }
        return answer;
    }
}
