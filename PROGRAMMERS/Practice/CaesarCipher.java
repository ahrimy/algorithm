/**
 * 연습문제
 * 시저 암호
 * Java
 */

public class CaesarCipher {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122) sb.append( (char)(97 + (s.charAt(i) - 97 + n)%26));
            else if(s.charAt(i) >= 65 && s.charAt(i) <= 90) sb.append( (char)(65 + (s.charAt(i) - 65 + n)%26));
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
