/*
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * 행렬 테두리 회전하기
 * Java
 */

import java.util.Arrays;

public class RotateMatrix {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = (i * columns) + j + 1;
            }
        }
        
        int[] answer = new int[queries.length]; 
        Arrays.fill(answer, 10000);
        
        int x1;
        int y1;
        int x2;
        int y2;
        int current;
        int prev;
        for(int r=0;r<answer.length;r++) {
            x1 = queries[r][0];
            y1 = queries[r][1];
            x2 = queries[r][2];
            y2 = queries[r][3];
            prev = 10000;
            for(int i=y1-1; i<y2; i++) {
                current = matrix[x1-1][i];
                if(current < answer[r]) answer[r] = current;
                matrix[x1-1][i] = prev;
                prev = current;
            }
            for(int i=x1; i<x2;i++) {
                current = matrix[i][y2-1];
                if(current < answer[r]) answer[r] = current;
                matrix[i][y2-1] = prev;
                prev = current;
            }
            for(int i=y2-2; i>y1-2;i--) {
                current = matrix[x2-1][i];
                if(current < answer[r]) answer[r] = current;
                matrix[x2-1][i] = prev;
                prev = current;
            }
            for(int i=x2-2;i > x1-2;i--) {
                current = matrix[i][y1-1];
                if(current < answer[r]) answer[r] = current;
                matrix[i][y1-1] = prev;
                prev = current;
            }
        }
        return answer;
    }
}
