/*
 * 연습문제
 * 문자열 내 p와 y의 개수
 * Java
 */

public class CountPAndY {
    boolean solution(String s) {
        // Java 8 기능 (가장 느림)
        // String str = s.toLowerCase();
        // 
        // long p = str.chars().filter(ch -> ch == 'p').count();
        // long y = str.chars().filter(ch -> ch == 'y').count();
        
        // 정규식 사용
        // int p = s.replaceAll("[pP]", "").length();
        // int y = s.replaceAll("[yY]", "").length();
        
        // 반복문 사용 (가장 빠름)
        String str = s.toLowerCase();
        char someChar = 'p';
        int p = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == someChar) {
                p++;
            }
        }
        
        someChar = 'y';
        int y = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == someChar) {
                y++;
            }
        }

        return p == y;
    }
}
