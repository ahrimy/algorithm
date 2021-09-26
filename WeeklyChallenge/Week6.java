/*
 * Weekly Challenge
 * 6주차 복서 정렬하기
 * Java
 */

import java.util.Arrays;

public class Week6 {
    public int[] solution(int[] weights, String[] head2head) {
        Boxer[] boxers = new Boxer[weights.length];
        for(int i=0;i<weights.length;i++) {
            boxers[i] = new Boxer(i+1, weights[i]);
        }
        for(int i=0;i<head2head.length;i++) {
            for(int j=0;j<head2head[i].length();j++) {
                if(i == j) continue;
                if(head2head[i].charAt(j) == 'N') continue;
                boxers[i].total++;
                if(head2head[i].charAt(j) == 'L') {
                    boxers[i].lose++;  
                }else {
                    boxers[i].win++;
                    if(boxers[i].weight < boxers[j].weight) boxers[i].winHeavier++;
                }
            }
        }
        for(Boxer boxer: boxers) {
            boxer.rate = boxer.total == 0 ? 0.0 : ((double)boxer.win / boxer.total) * 100;
        }
        Arrays.sort(boxers, (a,b) -> {
            if(a.rate == b.rate) {
                if(a.winHeavier == b.winHeavier) {
                    if(a.weight == b.weight) {
                        return a.idx > b.idx ? 1 : -1;
                    }
                    return b.weight > a.weight ? 1 : -1;
                }
                return b.winHeavier > a.winHeavier ? 1 : -1;
            }
            return b.rate > a.rate ? 1 : -1;
        });
        
        int[] answer = new int[boxers.length];
        for(int i=0;i<boxers.length;i++) {
            answer[i] = boxers[i].idx;
        }
        return answer;
    }
    class Boxer {
        int idx;
        int weight;
        int lose;
        int win;
        int winHeavier;
        int total;
        double rate;
        
        public Boxer(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
            this.lose = 0;
            this.win = 0;
            this.total = 0;
            this.winHeavier = 0;
        }
    }
}
