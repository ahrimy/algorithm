/**
 * 스택 / 큐
 * 주식가격
 * Java
 */
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int cnt = 0;
            while((cnt+1)+i<prices.length&&prices[i]<=prices[cnt+i]){
                cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}