/*
 * Weekly Challenge
 * 4주차 직업군 추천하기
 * Java
 */

import java.util.HashMap;

public class Week4 {
    public String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, Integer> preferenceMap = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for(int i=0;i<languages.length;i++){
            preferenceMap.put(languages[i], preference[i]);
        }
        
        String[] info;
        int total;
        for(String row: table){
            info = row.split(" ");
            total = 0;
            for(int i=1;i<=5;i++){
                total += (6-i) * preferenceMap.getOrDefault(info[i], 0);
            }
            scoreMap.put(info[0], total);
        }
        
        String answer = "";
        int max = 0;
        int current;
        for(String language: scoreMap.keySet()){
            current = scoreMap.get(language);
            if(current > max){
                max = current;
                answer = language;
            }else if(current == max){
                answer = language.compareTo(answer) < 0 ? language : answer;
            }
        }
        return answer;
    }
}