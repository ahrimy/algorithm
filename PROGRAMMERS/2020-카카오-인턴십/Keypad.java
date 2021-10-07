/*
 * 2020 카카오 인턴십
 * 키패드 누르기
 * Java
 */

import java.util.HashMap;

public class Keypad {
    public String solution(int[] numbers, String hand) {
        String[][] keypad = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"}};
        HashMap<String, int[]> map = new HashMap<>();
        int[] position;
        for(int i=0;i<4;i++) {
            for(int j=0;j<3;j++) {
                position = new int[2];
                position[0] = i;
                position[1] = j;
                map.put(keypad[i][j], position);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        int[] left = map.get("*");
        int[] right = map.get("#");
        int leftDistance;
        int rightDistance;
        for(int number: numbers){
            position = map.get(String.valueOf(number));
            if(position[1] == 0) {
                answer.append("L");
                left = position;
                continue;
            }
            if(position[1] == 2) {
                answer.append("R");
                right = position;
                continue;
            }
            leftDistance = Math.abs(left[0] - position[0]) + Math.abs(left[1] - position[1]);
            rightDistance = Math.abs(right[0] - position[0]) + Math.abs(right[1] - position[1]);
            
            if(leftDistance < rightDistance) {
                answer.append("L");
                left = position;
                continue;
            }
            if(leftDistance > rightDistance) {
                answer.append("R");
                right = position;
                continue;
            }
            
            if(hand.equals("left")) {
                answer.append("L");
                left = position;
            }else {
                answer.append("R");
                right = position;
            }
        }
        return answer.toString();
    } 
}
