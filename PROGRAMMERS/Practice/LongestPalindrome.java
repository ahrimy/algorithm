/**
 * 연습문제
 * 가장 긴 팰린드롬
 * Java
 */

public class LongestPalindrome {
    public int solution(String s)
    {
        int answer = 0;       
        String[] str = s.split("");
        int length = str.length;
        for(int i=length;i>0;i--) {
            for(int j=0;j<=length - i;j++) {
                if(isPalindrome(str, j, j + i)) {
                    answer = i;
                    break;
                }
            }
            if(answer > 0) break;
        }
        return answer;
    }
    
    public boolean isPalindrome(String[] str, int start, int end) {
        for(int i=0;i<=(end-start)/2;i++) {
            if(!str[i + start].equals(str[end - 1 -i])) return false;
        }
        return true;
    }
}
