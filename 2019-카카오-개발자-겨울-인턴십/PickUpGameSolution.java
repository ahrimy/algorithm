package kakaoIntershipTest2019w;
/*
 * 2019 카카오 개발자 겨울 인턴
 * 크레인 인형뽑기 게임
 * Java
 * */

public class PickUpGameSolution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int collects[] = new int[board.length*board.length];
        int cnt = 0;
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1]!=0){
                    collects[cnt] = board[j][moves[i]-1];
                    board[j][moves[i]-1]=0;
                    if(cnt>0){
                        if(collects[cnt]==collects[cnt-1]){
                            collects[cnt]=0;
                            collects[cnt-1]=0;
                            cnt-=2;
                            answer+=2;
                        }
                    }
                    cnt++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
