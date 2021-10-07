/*
 * 2021 카카오 채용연계형 인턴십
 * 거리두기 확인하기
 * Java
 */

public class CheckDistance {
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        boolean[][] visited;
        int result;
        for(int i=0;i<places.length;i++){
            visited = new boolean[places[i].length][places[i][0].length()];
            result = 0;
            for(int j=0;j<places[i].length;j++) {
                for(int k=0;k<places[i][j].length();k++){
                    if(places[i][j].charAt(k) != 'P') continue;
                    visited[j][k] = true;
                    result += dfs(places[i], visited, j, k, 0);
                    visited[j][k] = false;
                }
            }
            answer[i] = result > 0 ? 0 : 1;
        }
        return answer;
    }

    public int dfs(String[] place, boolean[][] visited, int r, int c, int count) {
        if(count > 2) return 0;
        if(count > 0 && place[r].charAt(c) == 'P') return 1;
        
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        int nextR;
        int nextC;
        int total = 0;
        
        for(int i=0;i<4;i++){
            nextR = r + x[i];
            nextC = c + y[i];
            if(nextR < 0 || nextR >= place.length) continue;
            if(nextC < 0 || nextC >= place[nextR].length()) continue;
            if(place[nextR].charAt(nextC) == 'X') continue;
            if(visited[nextR][nextC]) continue;
            
            visited[nextR][nextC] = true;
            total += dfs(place, visited, nextR, nextC, count+1);
            visited[nextR][nextC] = false;
        }
        return total;
    }
}
