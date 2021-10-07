/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * 타겟 넘버
 * Java
 */

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = bfs(target,numbers,0,0);
        return answer;
    }
    
    public int bfs(int target, int[] numbers, int count, int total){
        if(count==numbers.length){
            if(target==total){
                return 1;
            }else{
                return 0;
            }
        }
        int result = 0;
        result += bfs(target,numbers,count+1,total+numbers[count]);
        result += bfs(target,numbers,count+1,total-numbers[count]);
        return result;
    }
}