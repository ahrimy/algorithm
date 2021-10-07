import java.util.Arrays;

class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int min = 1;
        int max = distance;
        while(min<=max){
            int mid = (min+max)/2;
            int removed = 0;
            
            // mid 가 최소라고 가정
            // mid 보다 작은 거리가 있다면 삭제
            // 삭제되지 않은 가장 가까운 돌을 prev 에 저장 필요
            int prev = 0;
            for(int rock : rocks){
                if(mid > rock - prev) removed++;
                else prev = rock;
            }
            if(mid > distance-prev) removed++;
            
            if(n < removed){
                max = mid - 1;
            }else{
                min = mid + 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}