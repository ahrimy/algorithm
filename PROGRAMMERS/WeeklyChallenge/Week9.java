/*
 * Weekly Challenge
 * 9주차 전력망을 둘로 나누기
 * Java
 */

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Week9 {
    public int solution(int n, int[][] wires) {
        int answer = n;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] wire: wires) {
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        
        boolean[] visited;
        for(int[] wire: wires) {
            visited = new boolean[n];
            visited[wire[1]-1] = true;
            int first = calculate(map, visited, wire[0]);
            
            visited = new boolean[n];
            visited[wire[0]-1] = true;
            int second = calculate(map, visited, wire[1]);
            
            if(answer > Math.abs(first - second)) answer = Math.abs(first - second);
        }
        
        return answer;
    }
    public int calculate(Map<Integer, ArrayList<Integer>> map, boolean[] visited, int n) {
        if(visited[n-1]) return 0;
        
        visited[n-1] = true;
        ArrayList<Integer> list = map.get(n);
        int total = 1;
        for(int l : list) {
            total += calculate(map, visited, l);
        }
        return total;
    }
}
