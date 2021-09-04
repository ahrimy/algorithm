/*
 * 2019 KAKAO BLIND RECRUITMENT
 * 오픈채팅방 
 * Java
 */

import java.util.HashMap;

public class OpenChatting {
    
    public String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<>();
        
        int count = 0;
        // uid 최종 닉네임 확인
        for(String row : record){
            String[] command = row.split(" ");
            switch(command[0]){
                case "Change":
                    users.put(command[1], command[2]);
                    break;
                case "Enter":
                    users.put(command[1], command[2]);
                    count++;
                    break;
                case "Leave":
                    count++;
                    break;
            }
        }
        
        // 실제 메시지 저장
        String[] answer = new String[count];
        int index = 0;
        for(int i=0;i<record.length;i++){
            String[] command = record[i].split(" ");
            
            switch(command[0]){
                case "Enter":
                    answer[index++] = users.get(command[1]) + "님이 들어왔습니다.";
                    break;
                case "Leave":
                    answer[index++] = users.get(command[1]) + "님이 나갔습니다.";
                    break;
            }
        }
        return answer;
    }
}
