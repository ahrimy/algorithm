/**
 * 정렬
 * H-Index
 * Java
 */

import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
     Arrays.sort(citations);

        int h = 0;
        for(int i=0;i<citations.length;i++){
            h = citations.length-i;
            if(citations[i]>=h){
    answer = h;
                break;
            }
        }
 
        return answer;
    }
}