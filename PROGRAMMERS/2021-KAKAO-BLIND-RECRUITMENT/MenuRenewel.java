/*
 * 2021 KAKAO BLIND RECRUITMENT
 * 메뉴 리뉴얼 
 * Java
 */

import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class MenuRenewel {
    HashMap<String, Integer> menus;
    HashMap<Integer, ArrayList<String>> menuList;
    public String[] solution(String[] orders, int[] course) {
        menus = new HashMap<>();
        menuList = new HashMap<>();
        for(int c : course){
            menuList.put(c, new ArrayList<String>());    
        }
        
        for(String order: orders){
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            createMenu(new String(chars), 0, "");
        }
        
        for(ArrayList<String> list : menuList.values()){
            Collections.sort(list, (a,b) -> {
                return menus.get(b) - menus.get(a);
            });
        }
        
        ArrayList<String> selectedMenu = new ArrayList<>();
        int max;
        int index;
        ArrayList<String> targetList;
        for(int c: course){
            targetList = menuList.get(c);
            if(targetList.size() == 0) continue;
            max = menus.get(targetList.get(0));
            if(max < 2) continue;
            index = 0;
            while(index < targetList.size() && menus.get(targetList.get(index)) == max ){
                selectedMenu.add(targetList.get(index));
                index++;
            }
        }
        String[] answer = new String[selectedMenu.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = selectedMenu.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public void createMenu(String order, int depth, String menu){
        int count;
        ArrayList<String> list;
        for(int i=depth; i<order.length();i++){
            if(menuList.containsKey(menu.length() + 1)){
                list = menuList.get(menu.length() +1);
                if(!list.contains(menu + order.charAt(i))) list.add(menu + order.charAt(i));
               
                count = menus.getOrDefault(menu + order.charAt(i), 0);
                menus.put(menu + order.charAt(i), count + 1);
            }
            createMenu(order, i+1, menu + order.charAt(i));
        }
    }
}
