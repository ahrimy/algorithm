/*
 * 탐욕법(Greedy)
 * 조이스틱
 * Java
 */


public class JoyStick {
    public int min;
    public int solution(String name) {
        int[] updown = new int[name.length()];
        int total = 0;
        for(int i=0;i<name.length();i++) {
            char target = name.charAt(i);
            updown[i] = Math.min(target - 65, 91 - target);
            total += updown[i];
        }
        min = total + name.length() - 1;
        dfs(updown, new boolean[name.length()], 0, 1, -1, 0, total, name.length());
        
        return min;
    }
    
    public void dfs(int[] updown, boolean[] visited,int current, int direction,int count, int sum, int total, int n) {
        if(sum == total) {
            min = Math.min(sum+count, min);
            return;
        }
        
        if(visited[current]) {
            dfs(updown, visited, (current + direction + n)%n, direction, count+1, sum, total, n);
            return;
        }
        
        visited[current] = true;
        dfs(updown, visited, (current + 1)%n, 1, count+1, sum+updown[current], total, n);
        dfs(updown, visited, (current - 1 + n)%n, -1, count+1, sum+updown[current], total, n);
        visited[current] = false;
    }
}
