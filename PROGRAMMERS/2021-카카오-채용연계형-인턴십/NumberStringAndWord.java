/*
 * 2021 카카오 채용연계형 인턴십
 * 숫자 문자열과 영단어
 * Java
 */

public class NumberStringAndWord {
    public int solution(String s) {
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0;i<numStr.length;i++){
            s = s.replaceAll(numStr[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
