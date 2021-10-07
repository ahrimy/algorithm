/**
 * 해시
 * 위장
 * Java
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class SetClothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> closet = new HashMap<String,Integer>();
        for(int i=0;i<clothes.length;i++){
            int count = 1;
            if(closet.containsKey(clothes[i][1])){
                count += closet.get(clothes[i][1]);
            }
            closet.put(clothes[i][1],count);
        }
        int answer = 1;
        for(String key : closet.keySet()){
            answer *= (closet.get(key)+1);
        }
        answer -= 1;
        return answer;
    }
}