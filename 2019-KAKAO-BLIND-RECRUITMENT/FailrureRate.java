/*
 * 2019 KAKAO BLIND RECRUITMENT
 * 실패율 
 * Java
 */

import java.lang.Comparable;
import java.util.Arrays;

public class FailrureRate {

    public int[] solution(int N, int[] stages) {
        
        Stage[] stageCount = new Stage[N];
        for(int i=0;i<N;i++){
            stageCount[i] = new Stage(i+1);
        }
        
        for(int stage: stages){
            for(int i=0; i< stage-1; i++){
                stageCount[i].addTotal();
                stageCount[i].addCount();
            }
            if(stage > N) continue;
            stageCount[stage-1].addTotal();
        }
        
        Arrays.sort(stageCount);
        
        int[] answer = new int[N];
        
        for(int i=0;i<N;i++){
            answer[i] = stageCount[i].getN();
        }
        return answer;
    }
    
    private class Stage implements Comparable<Stage> {
        private int n;
        private int count; // 성공한 사용자
        private int total; // 도전한 사용자

        public Stage(int n){
            this.n = n;
            this.count = 0;
            this.total = 0;
        }

        public void addCount(){
            count++;
        }

        public void addTotal(){
            total++;
        }

        public int getN(){
            return n;
        }

        public int getCount(){
            return count;
        }

        public int getTotal(){
            return total;
        }

        public double getFailureRate(){
            
            // total-count 0일때, 나누기 하면 에러
            return (total-count) > 0 ? (double)(total-count)/total : 0.0;
        }

        @Override
        public int compareTo(Stage s) {
            if(this.getFailureRate() < s.getFailureRate()) { 
                return 1;
            }
            if(this.getFailureRate() == s.getFailureRate()){
                if(this.getN() > s.getN()){
                    return 1;
                }
            }
            return -1;
        }
    }
    
}
