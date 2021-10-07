import java.util.Arrays;

class Immigration {
    public long solution(int n, int[] times) {
        // 심사 시간 짧은 순으로 정렬
        Arrays.sort(times);
        
        long min = 1;
        long max = (long)times[times.length-1] * n;
        
        long answer = 0;
        while(min <= max){
            long mid = (min+max)/2;
            long sum = 0;
            for(int time : times){
                sum += mid/time;
            }
            
            if(sum >= n){      // mid 시간 동안 심사할 수 있는 사람이 n명 이상이면, 시간 더 줄여도 된다.
                max = mid - 1;
                answer = mid;
            }else{             // mid 시간 동안 심사할 수 있는 사람이 n보다 작으면, 시간 늘려야된다.
                min = mid + 1;
            }
            
        }
        
        return answer;
    }
}