/**
 * 연습문제
 * 가장 큰 정사각형 찾기
 * Java
 */


public class BiggestSquare {
    public int solution(int [][]board)
    {
        int answer = 0;
        if(board.length == 1) {
            for(int i=0;i<board[0].length;i++) {
                if(board[0][i] == 1) return 1;
            }
        }
        if(board[0].length == 1) {
            for(int i=0;i<board.length;i++) {
                if(board[i][0] == 1) return 1;
            }
        }
        for(int i=1;i<board.length;i++) {
            for(int j=1;j<board[i].length;j++) {
                if(board[i][j] == 0) continue;
                int min = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1]));
                board[i][j] = min + 1;
                answer = Math.max(answer, board[i][j] * board[i][j]);
            }
        }

        return answer;
    }
}
