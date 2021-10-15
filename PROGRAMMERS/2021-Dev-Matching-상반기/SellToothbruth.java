/*
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * 다단계 칫솔 판매
 * Java
 */

import java.util.Map;
import java.util.HashMap;

class SellToothbruth {
    Map<String, String> relations = new HashMap<>();
    Map<String, Integer> soldAmount = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        for(int i=0;i<enroll.length;i++) {
            relations.put(enroll[i], referral[i]);
            soldAmount.put(enroll[i], 0);
        }

        for(int i=0; i<seller.length;i++) {
            dfs(seller[i], amount[i]*100);
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0;i<answer.length;i++) {
            answer[i] = soldAmount.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
    
    public void dfs(String name, int money) {
        if(money == 0 || name.equals("-")) return;
        
        soldAmount.put(name, soldAmount.get(name) + (money-money/10));
        dfs(relations.get(name), money/10);   
    }
}