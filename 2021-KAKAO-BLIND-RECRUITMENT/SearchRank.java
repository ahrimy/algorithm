/*
 * 2021 KAKAO BLIND RECRUITMENT
 * 순위 검색
 * Java
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class SearchRank {
    public int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        for(String row: info) {
            createList(row, map);
        }
        
        // 미리 정렬
        for(ArrayList<Integer> value : map.values()) {
            Collections.sort(value);
        }
        
        ArrayList<Integer> list;
        int score;
        int[] answer = new int[query.length];
        String[] temp;
        int min;
        int max;
        int mid;
        int index;
        for(int i=0;i<query.length;i++) {
            temp = query[i].replaceAll(" and ", "").split(" ");
            list = map.getOrDefault(temp[0], new ArrayList<Integer>(0));
            score = Integer.parseInt(temp[1]);
            // Collections.sort(list); // 여기서 정렬하면 시간 초과
            
            min = 0;
            max = list.size()-1;
		    while(min<=max) {
                mid =(min+max)/2;
                if(list.get(mid) < score) {
                    min = mid+1;	
                }else {
                    max = mid-1;
                }
		    }
            answer[i] = list.size() - min;
        }
        return answer;
    }
    // dfs 로 변경 필요
    public void createList(String row, HashMap<String, ArrayList<Integer>> map) {
        String key;    
        ArrayList<Integer> tempList;
        String[] infoArr = row.split(" ");
        key = infoArr[0]+infoArr[1]+infoArr[2]+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+infoArr[1]+infoArr[2]+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = infoArr[0]+"-"+infoArr[2]+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = infoArr[0]+infoArr[1]+"-"+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = infoArr[0]+infoArr[1]+infoArr[2]+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+"-"+infoArr[2]+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+infoArr[1]+"-"+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+infoArr[1]+infoArr[2]+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = infoArr[0]+"-"+"-"+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = infoArr[0]+"-"+infoArr[2]+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = infoArr[0]+infoArr[1]+"-"+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = infoArr[0]+"-"+"-"+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+infoArr[1]+"-"+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+"-"+infoArr[2]+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+"-"+"-"+infoArr[3];
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
        key = "-"+"-"+"-"+"-";
        tempList = map.getOrDefault(key, new ArrayList<Integer>());
        tempList.add(Integer.parseInt(infoArr[4]));
        map.put(key, tempList);
    }
}
