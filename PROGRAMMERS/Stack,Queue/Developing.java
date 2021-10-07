/**
 * 스택 / 큐
 * 기능개발
 * Java
 */
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;
class Progress{
   
    private int progress;
    private int speed;
    public Progress(int progress,int speed){
        this.progress = progress;
        this.speed = speed;
    }
    public int getProgress(){
        return progress;
    }
    public void processing(){
        if(progress<100){
            progress+=speed;
        }
        if(progress>=100){
            progress=100;
        }
    }
}
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Progress> progressList = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            progressList.offer(new Progress(progresses[i],speeds[i]));
        }
        while(progressList.peek()!=null){
            Iterator<Progress> it = progressList.iterator();
            while(it.hasNext()){
                it.next().processing();
            }
            int cnt = 0;
            while(progressList.peek()!=null&&progressList.peek().getProgress()==100){
                progressList.poll();
                cnt++;
            }
            
            if(cnt>0){
                int temp[] = new int[answer.length+1];
                for(int i=0;i<answer.length;i++){
                    temp[i] = answer[i];
                }
                temp[answer.length] = cnt;
                answer = temp;
            }
            
        }
        
        return answer;
    }
}