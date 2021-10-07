/*
 * 2019 카카오 개발자 겨울 인턴십
 * 튜플
 * Java
 */
public class Tuple {
	class Solution {
	    public int[] solution(String s) {
	        int[] answer = {};
	        s = s.substring(2,s.length()-2);
	        String list[] = s.split("}");
	        for(int i=1;i<list.length;i++){
	            list[i] = list[i].substring(2);    
	        }
	        for(int i=0;i<list.length;i++){
	            for(int j=0;j<list.length-1-i;j++){
	                if(list[j+1].length()<list[j].length()){
	                    String temp = list[j];
	                    list[j] = list[j+1];
	                    list[j+1] = temp;
	                }
	            }
	        }
	       String[] answerS = new String[list.length];
	        answerS[0] = list[0];
	        for(int i=1;i<list.length;i++){
	            String[] temp = list[i].split(",");
	            int check[] = new int[temp.length];
	            for(int j=0;j<temp.length;j++){
	                for(int k=0;k<i;k++){
	                    if(answerS[k].equals(temp[j])){
	                        check[j] = 1;;
	                    }
	                }
	            }
	            for(int j=0;j<temp.length;j++){
	                if(check[j]==0){
	                    answerS[i] = temp[j];
	                }
	            }
	        }

	       answer = new int[list.length];

	        for(int i=0;i<list.length;i++){
	            answer[i] = Integer.parseInt(answerS[i]);
	        }
	        return answer;
	    }
	}
}
