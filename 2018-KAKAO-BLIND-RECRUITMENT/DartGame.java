/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [1차] 다트 게임 
 * Java
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

public class DartGame {
    public int solution(String dartResult) {
        Pattern pattern = Pattern.compile("([0-9]+)([A-Z])([\\*|#]?)"); 
        Matcher matcher = pattern.matcher(dartResult);
        // 매칭되는 pattern 개수 계산
        int total = 0;
        while(matcher.find()){
            total++;
        }
        
        int[]score = new int[total];
        matcher = pattern.matcher(dartResult);
        int index = 0;
        // 매칭된 pattern 내에서 grouping
        while(matcher.find()){
            // 점수
            score[index] = Integer.parseInt(matcher.group(1));

            // 보너스
            int n = matcher.group(2).equals("S") ? 1 : matcher.group(2).equals("D") ? 2 : 3;
            score[index] = (int)Math.pow(score[index], n);
            
            // 옵션
            if(matcher.group(3).equals("*")){
                score[index] *= 2;
                if(index > 0) score[index-1] *= 2;
            }else if(matcher.group(3).equals("#")){
                score[index] *= -1;
            }
            index++;
        }

        int answer = 0;
        for(int s : score){
            answer += s;
        }
        return answer;
    }
}
