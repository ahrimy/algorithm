/**
 * 월간 코드 챌린지 시즌 1
 * 이진 변환 반복하기
 * Java
 */
 
class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        String str = s;
        while(!str.equals("1")){
            answer[0]++;
            int one = 0;
            for(int i=0;i<str.length();i++){
                if(str.substring(i,i+1).equals("0")){
                    answer[1]++;
                }else{
                    one++;
                }
            }
            str = "";
            while(one>0){
                String x = String.valueOf(one%2);
                one = one/2;
                str = x+str;
            }
        }
        return answer;
    }
}
