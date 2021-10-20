/**
 * 월간 코드 챌린지 시즌 3
 * n^2 배열 자르기
 * Java
 */

public class SplitArray {
    public int[] solution(int n, long left, long right) {
        int[] temp = new int[(int)(right-left+1)];
        
        long index = left;
        for(int i=0;i<temp.length;i++) {
            if(index/n > index%n) temp[i] = (int)((index++)/n+1);
            else temp[i] = (int)((index++)%n+1);
        }
       
        return temp;
    }
}
