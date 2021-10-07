/**
 * 그래프
 * 가장 먼 노드
 * Java
 */

import java.util.Queue;
import java.util.LinkedList;

public class FarthestNode {
    public int solution(int n, int[][] edge) {
        // int 로 하면 메모리 초과
        boolean[][] map = new boolean[n+1][n+1];
        for(int i=0;i<edge.length;i++) {
            map[edge[i][0]][edge[i][1]] = true;
            map[edge[i][1]][edge[i][0]] = true;
        }
        
        int[] distance = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int target;
        while(!queue.isEmpty()) {
            target = queue.poll();
            for(int i=2;i<=n;i++) {
                if(distance[i] > 0 || !map[target][i]) continue;
                distance[i] = distance[target] + 1;
                queue.offer(i);
            }
        }
        
        int answer = 0;
        int max = 0;
        for(int d: distance) {
            if(d > max) {
                max = d;
                answer = 1;
            }else if(d == max) {
                answer++;   
            }
        }
        return answer;
    }
}
