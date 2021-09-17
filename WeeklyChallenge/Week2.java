/*
 * Weekly Challenge
 * 2주차 상호평가
 * Java
 */

public class Week2 {
    public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        // String 에 더하는 것보다 StringBuilder 사용하는게 빠름
        
        int max;
        int min;
        int maxCount;
        int minCount;
        int total;
        double score;
        for(int i=0;i<scores[0].length;i++){
            max = scores[0][i];
            min = scores[0][i];
            maxCount = 0;
            minCount = 0;
            total = 0;
            for(int j=0;j<scores.length;j++){
                total += scores[j][i];
                if(scores[j][i] > max){
                    maxCount = 1;
                    max = scores[j][i];
                }else if(scores[j][i] == max){
                    maxCount++;
                }
                if(scores[j][i] < min){
                    minCount = 1;
                    min = scores[j][i];
                }else if(scores[j][i] == min){
                    minCount++;
                }
            }
            
            if(max == scores[i][i] && maxCount == 1){
                score = (total - max) / (double)(scores.length-1);
            }else if(min == scores[i][i] && minCount == 1){
                score = (total - min) / (double)(scores.length-1);
            }else{
                score = total / (double)scores.length;
            }
            if(score >= 90.0){
                sb.append("A");
            }else if(score >= 80.0){
                sb.append("B");
            }else if(score >= 70.0){
                sb.append("C");
            }else if(score >= 50.0){
                sb.append("D");
            }else{
                sb.append("F");
            }
        }
        return sb.toString();
    }
}
