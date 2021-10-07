/*
 * 2019 카카오 개발자 겨울 인턴십
 * 호텔 방 배정
 * Java
 */

import java.util.HashMap;
 
public class HotelRoom {
    private HashMap<Long,Long> map = new HashMap<Long,Long>();
        
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i = 0;i<room_number.length;i++){
            long room = room_number[i];
            answer[i]= find(room);
        }
        return answer;
    }
    
    private long find(long room){
        if(!map.containsKey(room)){
            map.put(room,room+1);
            return room;
        }
        map.put(room,find(map.get(room)));
        return map.get(room);
    }
}
