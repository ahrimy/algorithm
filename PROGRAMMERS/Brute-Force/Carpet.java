/*
 * 완전탐색
 * 카펫
 * Java
 */
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        answer[0] = ((brown/2-2)+(int)Math.sqrt((2-brown/2)*(2-brown/2)-4*yellow))/2+2;
        answer[1] = ((brown/2-2)-(int)Math.sqrt((2-brown/2)*(2-brown/2)-4*yellow))/2+2;
        return answer;
    }
}
