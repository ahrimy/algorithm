/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [3차] n진수 게임
 * Java
 */

class BaseNGame {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        while(sb.length() < t*m) {
            sb.append(getNumberStr(number++, n));
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<t;i++) {
            answer.append(sb.charAt((i*m + p)-1));
        }
        
        return answer.toString();
    }
    
    public String getNumberStr(int num, int n) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "0";
        while(num > 0) {           
            sb.insert(0, Integer.toHexString(num % n).toUpperCase());
            num /= n;
        }
        return sb.toString();
    }
}
