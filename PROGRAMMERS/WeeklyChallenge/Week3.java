/*
 * Weekly Challenge
 * 3주차 퍼즐 조각 채우기
 * Java
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Week3 {
    public int solution(int[][] game_board, int[][] table) {
        
        List<int[][]> blocks = new ArrayList<>();
        
        // Block 찾기
        for(int i=0;i<table.length;i++) {
            for(int j=0;j<table[i].length;j++) {
                if(table[i][j] != 1) continue;
                int[][] temp = new int[table.length][table[0].length];
                searchBlock(temp, i, j, table, 1);              
                blocks.add(getBlock(temp));
            }
        }
        

        List<int[][]> filledBlocks = new ArrayList<>();
        
        // 빈칸이랑 비교
        for(int i=0;i<game_board.length;i++) {
            for(int j=0;j<game_board[i].length;j++) {
                if(game_board[i][j] != 0) continue;
                
                int[][] temp = new int[game_board.length][game_board[0].length];
                searchBlock(temp, i, j, game_board, 0);
                int[][] holeBlock = getBlock(temp);
                
                boolean isFound = false;
                Iterator<int[][]> iter = blocks.iterator();
                int[][] block;
                while(iter.hasNext()) {
                    block = iter.next();
                    for(int k=0;k<4;k++) {
                        if(compareBlock(block, holeBlock)) {
                            isFound = true;
                            break;
                        }
                        block = rotate(block);
                    }
                    if(isFound) {
                        filledBlocks.add(block);
                        iter.remove();
                        break;
                    }
                }
            }
        }
        
        
        // 사용된 Block total 계산
        int answer = 0;
        for(int[][] block : filledBlocks) {
            for(int i=0;i<block.length;i++) {
                for(int j=0;j<block[i].length;j++) {
                    if(block[i][j] == 1) answer++;
                }
            }
        }
        
        return answer;
    }
    
    public void searchBlock(int[][] block, int x, int y, int[][] table, int target) {
        if(table[x][y] != target) return;
        block[x][y] = 1;
        table[x][y] = 2;
        if(x > 0) searchBlock(block, x-1, y, table, target);
        if(y > 0) searchBlock(block, x, y-1, table, target);
        if(x < table.length-1 && x < block.length-1) searchBlock(block, x+1, y, table, target);
        if(y < table[0].length-1 && y < block[0].length-1) searchBlock(block, x, y+1, table, target);
    }
    
    public int[][] getBlock(int[][] block) {
        int x1 = block.length - 1;
        int x2 = 0;
        int y1 = block[0].length - 1;
        int y2 = 0;
        
        for(int i=0;i<block.length;i++) {
            for(int j=0;j<block[0].length;j++) {
                if(block[i][j] == 0) continue;
                if(x1 > i) x1 = i;
                if(x2 < i) x2 = i;
                if(y1 > j) y1 = j;
                if(y2 < j) y2 = j;
            }
        }
        
        int[][] newBlock = new int[x2 - x1 + 1][y2 - y1 + 1];
        for(int i=x1;i<=x2;i++) {
            for(int j=y1;j<=y2;j++) {
                newBlock[i-x1][j-y1] = block[i][j];
            }
        }
        return newBlock;
    }
    
    public int[][] rotate(int[][] block) {
        int[][] newBlock = new int[block[0].length][block.length];
        for(int i=0;i<block.length;i++) {
            for(int j=0;j<block[i].length;j++) {
                newBlock[j][block.length-1-i] = block[i][j];
            }
        }
        return newBlock;                
    }
    
    public boolean compareBlock(int[][] a, int[][] b) {
        if(a.length != b.length) return false;
        if(a[0].length != b[0].length) return false;
        
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
