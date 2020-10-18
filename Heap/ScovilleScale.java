/**
 * 힙
 * 더 맵게
 * Java
 */

import java.util.PriorityQueue;
class Solution {
  
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int i=0;i<scoville.length;i++){
            heap.offer(scoville[i]);
        }
       
        while(heap.peek()<K&&heap.size()>1){
            int temp1 = heap.poll();
            int temp2 = heap.poll();
            int value = temp1+(temp2*2);

            heap.offer(value);
            answer++;
        }
        if(heap.peek()<K){
            answer= -1;
        }
        return answer;
    }

    
}