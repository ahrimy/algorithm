/*
 * 2019 카카오 개발자 겨울 인턴
 * 징검다리 건너기
 * Java
 * */

public class SteppingStone {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;

        while(left<=right){
            int mid = (left+right)/2;

            int max = 0;
            int count = 0;
            for(int i=0;i<stones.length;i++){
                if(stones[i] >= mid){
                    count = 0;
                }else{
                    count++;
                    if(count > max){
                        max = count;
                    }
                } 
            }
            if(max >= k){
                right = mid-1;
            }else{
                left = mid+1;
                answer = mid;
            }
        }

        return answer;
    }
}
