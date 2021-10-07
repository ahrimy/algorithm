import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static Queue<Integer> queue = new LinkedList();
    public static boolean[] visited;
    public static int[][] computers;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Solution.computers = computers;
        visited = new boolean[n];
        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            bfs(i);
            answer++;
        }
        return answer;
    }
    public static void bfs(int b){
        queue.add(b);
        visited[b] = true;
        
        int node;
        while(!queue.isEmpty()){
            node = queue.poll();
            for(int i=0;i<computers[node].length;i++){
                if(computers[node][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
            
        }
        
    }
}