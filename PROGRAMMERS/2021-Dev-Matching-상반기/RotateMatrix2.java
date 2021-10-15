/*
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * 행렬 테두리 회전하기
 * Java
 */

 public class RotateMatrix2 {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] data = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=1;j<=columns;j++) {
                data[i][j-1] = i * columns + j; 
            }
        }
        
        int[] answer = new int[queries.length];
        
        for(int i=0;i<queries.length;i++) {
            answer[i] = rotate(data, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
        return answer;
    }
    
    public int rotate(int[][] data, int x1, int y1, int x2, int y2) {
        int total = (x2 - x1 + 1) * (y2 - y1 + 1) - (x2 - x1 - 1) * (y2 - y1 - 1);
        int count = 0;
        int[] direction = {0, 1};
        
        int min = data[x1][y1];
        int prev = data[x1][y1];
        int currentX = x1 + direction[0];
        int currentY = y1 + direction[1];
        
        while(count < total) {
            int temp = data[currentX][currentY];
            data[currentX][currentY] = prev;
            count++;
            if(currentX == x1 && currentY == y2) {
                direction[0] = 1;
                direction[1] = 0;
            }else if(currentX == x2 && currentY == y2 ) {
                direction[0] = 0;
                direction[1] = -1;
            }else if(currentX == x2 && currentY == y1) {
                direction[0] = -1;
                direction[1] = 0;
            }
            
            currentX += direction[0];
            currentY += direction[1];
            prev = temp;
            if(prev < min) min = prev;
        }
        
        return min;
    }
}
