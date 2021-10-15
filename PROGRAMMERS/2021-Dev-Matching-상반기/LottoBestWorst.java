/*
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * 로또의 최고 순위와 최저 순위
 * Java
 */

import java.util.Set;
import java.util.HashSet;

public class LottoBestWorst {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        
        int unknown = 0;
        for(int lotto : lottos) {
            if(lotto > 0) set.add(lotto);
            else unknown++;
        }
        
        int matched = 0;
        for(int win_num : win_nums) {
            if(set.contains(win_num)) matched++;
        }
        
        int[] answer = new int[2];
        int highest = matched+unknown;
        if(highest < 2) answer[0] = 6;
        else answer[0] = 7 - highest;
        
        if(matched < 2) answer[1] = 6;
        else answer[1] = 7 - matched;
        
        return answer;
    }
}
