/*
 * Weekly Challenge
 * 5주차 모음사전
 * Java
 */

public class Week5 {
    public int solution(String word) {
        int[] wordNumber = new int[5];
        for(int i=0;i<word.length();i++) {
            switch(word.charAt(i)) {
                case 'A':
                    wordNumber[i] = 1;
                    break;
                case 'E':
                    wordNumber[i] = 2;
                    break;
                case 'I':
                    wordNumber[i] = 3;
                    break;
                case 'O':
                    wordNumber[i] = 4;
                    break;
                case 'U':
                    wordNumber[i] = 5;
                    break;
            }
        }
        int answer = wordNumber[0];
        int prevSum = wordNumber[0] - 1;
        for(int i=1;i<5;i++) {
            answer += (prevSum * 5) + wordNumber[i];
            prevSum = (prevSum * 5) + (wordNumber[i] > 0 ? wordNumber[i] - 1 : 0);
        }
        return answer;
    }
}
